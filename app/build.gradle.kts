plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    kotlin("js") version "1.6.10"
    kotlin("plugin.serialization") version "1.6.10"

}

group="me.konso"
version="0.0.1-SNAPSHOT"

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use the Kotlin JS standard library.
    implementation(kotlin("stdlib-js"))

    // https://mvnrepository.com/artifact/org.jetbrains.kotlin-wrappers/kotlin-browser
    implementation("org.jetbrains.kotlin-wrappers:kotlin-browser:0.0.1-pre.312-kotlin-1.6.10")

    // https://mvnrepository.com/artifact/org.jetbrains.kotlin-wrappers/kotlin-react
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:17.0.2-pre.312-kotlin-1.6.10")

    // https://mvnrepository.com/artifact/org.jetbrains.kotlin-wrappers/kotlin-react-dom
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:17.0.2-pre.312-kotlin-1.6.10")

    // https://mvnrepository.com/artifact/org.jetbrains.kotlin-wrappers/kotlin-react-router-dom
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:6.2.1-pre.312-kotlin-1.6.10")

    // https://mvnrepository.com/artifact/org.jetbrains.kotlin-wrappers/kotlin-react-css
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-css:17.0.2-pre.312-kotlin-1.6.10")

    // https://mvnrepository.com/artifact/org.jetbrains.kotlin-wrappers/kotlin-extensions
    implementation("org.jetbrains.kotlin-wrappers:kotlin-extensions:1.0.1-pre.312-kotlin-1.6.10")

}

kotlin {
    js(LEGACY) {
        binaries.executable()
        browser {
            runTask{
                devServer=org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig.DevServer(
                    port= 3000,
                    proxy = mutableMapOf("/api" to mapOf("target" to "http://localhost:8080")),
                    contentBase = mutableListOf("$buildDir/processedResources/js/main")
                )
            }
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
}