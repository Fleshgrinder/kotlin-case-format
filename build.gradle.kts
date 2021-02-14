import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.30"
    id("org.jetbrains.dokka") version "1.4.20"
    signing
    id("de.marcphilipp.nexus-publish") version "0.4.0"
    id("io.codearte.nexus-staging") version "0.22.0"
}

repositories {
    mavenCentral()
    maven("https://dl.bintray.com/jetbrains/markdown")
    maven("https://dl.bintray.com/korlibs/korlibs")
    maven("https://dl.bintray.com/kotlin/dokka")
    maven("https://dl.bintray.com/kotlin/kotlinx")
}

dependencies {
    api(kotlin("stdlib", "[1.3,)"))

    val junitVersion = "5.7.1"
    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly(platform("org.junit:junit-bom:$junitVersion"))
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

java {
    withSourcesJar()
    withJavadocJar()
}

kotlin {
    explicitApi()
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        allWarningsAsErrors = true
        jvmTarget = file(".java-version").readText().trim()
        apiVersion = "1.3"
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.dokkaJavadoc {
    outputDirectory.set(tasks.javadoc.map { checkNotNull(it.destinationDir) })
}

tasks.javadoc {
    dependsOn(tasks.dokkaJavadoc)
}

tasks.jar {
    manifest {
        attributes["Name"] = "com/fleshgrinder/extensions/kotlin/"
        attributes["Specification-Title"] = "Kotlin Case Format"
        attributes["Specification-Version"] = project.version
        attributes["Specification-Vendor"] = "Fleshgrinder"
        attributes["Implementation-Title"] = "com.fleshgrinder.extensions.kotlin"
        attributes["Implementation-Vendor"] = "Fleshgrinder"
        attributes["Implementation-Version"] = gitCommitId.get()
        attributes["Sealed"] = false
    }
}

val gitCommitId = provider { file(".git/refs/heads/master").readText().trim() }

if ((version as String).endsWith("-SNAPSHOT")) {
    gradle.startParameter.excludedTaskNames.apply {
        add("signMavenJavaPublication")
        add("closeAndReleaseRepository")
    }
}

publishing {
    publications {
        create<MavenPublication>("sonatype") {
            from(components["java"])
            pom {
                name.set("Kotlin Case Format")
                description.set(project.description)
                url.set("https://github.com/Fleshgrinder/kotlin-case-format")
                inceptionYear.set("2018")
                properties.put("commit", gitCommitId)
                licenses {
                    license {
                        name.set("Unlicense")
                        url.set("https://unlicense.org/")
                        distribution.set("repo")
                    }
                }
                developers {
                    developer {
                        id.set("Fleshgrinder")
                        name.set("Richard Fussenegger")
                        email.set("Fleshgrinder@users.noreply.github.com")
                    }
                }
                scm {
                    url.set("https://github.com/Fleshgrinder/kotlin-case-format")
                    connection.set("scm:https://github.com/Fleshgrinder/kotlin-case-format.git")
                    developerConnection.set("scm:git@github.com:Fleshgrinder/kotlin-case-format.git")
                }
                issueManagement {
                    system.set("GitHub")
                    url.set("https://github.com/Fleshgrinder/kotlin-case-format/issues")
                }
            }
        }
    }
}

nexusStaging {
    packageGroup = "com.fleshgrinder"
    stagingProfileId = "141a1dad946f"
}

nexusPublishing {
    repositories {
        sonatype {
            // Documentation mentions that it will automatically take these
            // values from nexusStaging but it actually does not work and
            // :initializeSonatypeStagingRepository fails. Hence, we have to
            // explicitly call this here.
            username.set(project.providers.gradleProperty("nexusUsername").forUseAtConfigurationTime())
            password.set(project.providers.gradleProperty("nexusPassword").forUseAtConfigurationTime())
        }
    }
}

signing {
    sign(publishing.publications["sonatype"])
}
