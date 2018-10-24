import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.dokka.gradle.LinkMapping
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    `maven-publish`
    kotlin("jvm") version "1.2.71"
    id("org.jetbrains.dokka") version "0.9.17"
    id("org.jlleitschuh.gradle.ktlint") version "6.2.0"
}

description = "String extension functions to convert between various case formats (camelCase, dash-case, …)"
group = "com.fleshgrinder.kotlin"
version = "0.1.0"

fun env(propertyName: String): String? = System.getenv(propertyName.replace('.', '_').toUpperCase())
fun config(name: String): String = env(name) ?: project.property(name) as String
fun configOrNull(name: String): String? = env(name) ?: project.findProperty(name) as String?

dependencies {
    api(kotlin("stdlib", "[1.0,)"))

    val junitVersion = config("org.junit.jupiter.version")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

repositories {
    jcenter()
}

tasks.remove(tasks["javadoc"])

fun DokkaTask.addLinkMapping(dir: String, url: String, suffix: String) = apply {
    linkMappings.add(LinkMapping().apply {
        this.dir = dir
        this.url = url
        this.suffix = suffix
    })
}

val dokka by tasks.getting(DokkaTask::class) {
    outputDirectory = "$buildDir/javadoc"
    includes = listOf("README.md")
    addLinkMapping(
        dir = "src/main/kotlin",
        url = "https://github.com/Fleshgrinder/kotlin-case-format/tree/master/src/main/kotlin",
        suffix = "#L"
    )
    samples += "$rootDir/src/test/kotlin"
}

val docs by tasks.registering(Copy::class) {
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    description = "Copies the Dokka generated documentation into the `/docs` directory for GitHub publishing."
    dependsOn("cleanDocs", dokka)
    from("${dokka.outputDirectory}/style.css")

    val hljs = """
    <link rel="stylesheet" href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@9.13.1/build/styles/atom-one-dark.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@9.13.1/build/highlight.min.js"></script>
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@9.13.1/build/languages/kotlin.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
    """

    from("${dokka.outputDirectory}/${dokka.moduleName}") {
        eachFile {
            println(path)
            filter {
                when (path) {
                    "package-list" -> if (it.startsWith('$')) "" else it
                    else -> it.replace("../style.css\">", "./style.css\">$hljs")
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
    gradleVersion = config("org.gradle.version")
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
        val user = configOrNull("com.bintray.user")
        val key = configOrNull("com.bintray.key")

        if (user == null && key == null) {
            maven(uri("$buildDir/local-maven-repository"))
        } else {
            maven(uri("https://api.bintray.com/maven/$user/$group/$name/;publish=1")) {
                name = "bintray"
                credentials {
                    username = user
                    password = key
                }
            }
        }
    }

    publications {
        register("mavenJava", MavenPublication::class) {
            from(components["java"])
            artifact(sourcesJar.get())
            artifact(javadocJar.get())
        }
    }
}
