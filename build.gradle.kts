plugins {
    kotlin("jvm") version embeddedKotlinVersion
}

java {
    toolchain.languageVersion.set(libs.versions.java.map(JavaLanguageVersion::of))
}

kotlin {
    explicitApi()
}
