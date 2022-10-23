import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    jacoco
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.jmh)
    signing
    `maven-publish`
    alias(libs.plugins.publishing.dokka)
    alias(libs.plugins.publishing.nexus)
}

dependencies {
    dokkaHtmlPlugin(libs.dokka.javadoc)
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.api)
    testRuntimeOnly(libs.junit.runtime)
}

idea {
    module {
        isDownloadJavadoc = false
        isDownloadSources = !System.getenv().containsKey("CI")
    }
}

java {
    withSourcesJar()
    withJavadocJar()
}

kotlin {
    explicitApi()
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

signing {
    isRequired = !version.toString().endsWith("-SNAPSHOT")
    sign(publishing.publications)
}

repositories {
    mavenCentral()
}

tasks {
    jar {
        isPreserveFileTimestamps = false
        isReproducibleFileOrder = true
    }

    test {
        useJUnitPlatform()
    }

    withType<KotlinCompile>().configureEach {
        kotlinOptions {
            allWarningsAsErrors = true
            jvmTarget = file(".java-version").readText().trim()
        }
    }
}
