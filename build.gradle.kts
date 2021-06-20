import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.gradle.ext.ModuleSettings
import org.jetbrains.gradle.ext.PackagePrefixContainer

plugins {
    kotlin("jvm") version "1.4.32"

    id("idea")
    id("org.jetbrains.gradle.plugin.idea-ext") version "1.0"

    id("maven-publish")
    id("signing")
    id("org.jetbrains.dokka") version "1.4.32"
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
}

val gitCommitId = provider { file(".git/refs/heads/main").readText().trim() }
val javaVersion = provider { file(".java-version").readText().trim() }

repositories {
    mavenCentral()
}

dependencies {
    api(kotlin("stdlib", "[1.3,)"))

    testImplementation(platform("org.junit:junit-bom:5.7.1"))
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

idea {
    module {
        isDownloadJavadoc = false
        isDownloadSources = !System.getenv().containsKey("CI")

        ((this as ExtensionAware).the<ModuleSettings>() as ExtensionAware).configure<PackagePrefixContainer> {
            this["src/main/kotlin"] = "com.fleshgrinder"
            this["src/test/kotlin"] = group as String
        }
    }
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
        jvmTarget = javaVersion.get()
        apiVersion = "1.3"
        languageVersion = "1.3"
    }
}

tasks.test.configure {
    useJUnitPlatform()
}

tasks.dokkaJavadoc.configure {
    outputDirectory.set(tasks.javadoc.map { checkNotNull(it.destinationDir) })
}

tasks.javadoc.configure {
    dependsOn(tasks.dokkaJavadoc)
}

tasks.jar.configure {
    manifest {
        attributes["Name"] = "com/fleshgrinder/kotlin/"
        attributes["Specification-Title"] = "Kotlin Case Format"
        attributes["Specification-Version"] = project.version
        attributes["Specification-Vendor"] = "Fleshgrinder"
        attributes["Implementation-Title"] = "com.fleshgrinder.kotlin"
        attributes["Implementation-Vendor"] = "Fleshgrinder"
        attributes["Implementation-Version"] = gitCommitId.get()
        attributes["Sealed"] = false
    }
}

publishing {
    publications {
        register<MavenPublication>("sonatype") {
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
                        comments.set("This is a public domain dedication")
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

nexusPublishing {
    repositories {
        sonatype {
            stagingProfileId.set("141a1dad946f")
        }
    }
}

signing {
    sign(publishing.publications["sonatype"])
}
