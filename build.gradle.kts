import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.dokka.gradle.LinkMapping
import org.jetbrains.dokka.gradle.PackageOptions
import org.jetbrains.dokka.DokkaConfiguration.ExternalDocumentationLink
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.net.URL

plugins {
    `java-library`
    `maven-publish`
    kotlin("jvm") version "1.2.71"
    id("org.jetbrains.dokka") version "0.9.17"
}

description = "Utility functions to convert between various case formats."
group = "com.fleshgrinder.extensions.kotlin"
version = "1.0.0"

fun v(propertyName: String): String =
    project.property(propertyName).toString()

dependencies {
    implementation(kotlin("stdlib"))

    val junitVersion = v("org.junit.jupiter.version")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

repositories {
    jcenter()
}

tasks.remove(tasks["javadoc"])

val dokka by tasks.getting(DokkaTask::class) {
    outputDirectory = "$buildDir/javadoc"
    includes = listOf("README.md")
}

val docs by tasks.registering(Copy::class) {
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    description = "Copies the Dokka generated documentation into the `/docs` directory for GitHub publishing."
    dependsOn("cleanDocs", dokka)
    from("${dokka.outputDirectory}/style.css")
    from("${dokka.outputDirectory}/${dokka.moduleName}") {
        eachFile {
            println(path)
            filter {
                when (path) {
                    "package-list" -> if (it.startsWith('$')) "" else it
                    else -> it.replace("../style.css", "./style.css")
                }
            }
        }
    }
    into("$rootDir/docs")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        allWarningsAsErrors = true
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks.withType<Wrapper> {
    gradleVersion = v("org.gradle.version")
    distributionType = Wrapper.DistributionType.ALL
}

val sourcesJar by tasks.registering(Jar::class) {
    group = "build"
    description = "Assembles a jar archive containing the source files."
    classifier = "sources"
    from(sourceSets["main"].allSource)
}

val javadocJar by tasks.registering(Jar::class) {
    group = "build"
    description = "Assembles a jar archive containing the source documentation."
    classifier = "javadoc"
    from(dokka)
}

publishing {
    repositories {
        //mavenCentral()
        maven(uri("$buildDir/repository"))
    }
    publications {
        register("mavenJava", MavenPublication::class.java) {
            from(components["java"])
            artifact(sourcesJar.get())
            artifact(javadocJar.get())
        }
    }
}
