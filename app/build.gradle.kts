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

    // Ktor Core
    implementation("io.ktor:ktor-client-core:1.6.7")

    // Ktor Client
    implementation("io.ktor:ktor-client-cio:1.6.7")

    // Kotlin/JS React
    implementation("org.jetbrains.kotlin-wrappers:kotlin-browser:0.0.1-pre.312-kotlin-1.6.10")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:17.0.2-pre.312-kotlin-1.6.10")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:17.0.2-pre.312-kotlin-1.6.10")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:6.2.1-pre.312-kotlin-1.6.10")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-css:17.0.2-pre.312-kotlin-1.6.10")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-extensions:1.0.1-pre.312-kotlin-1.6.10")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-mui:5.5.0-pre.314-kotlin-1.6.10")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-mui-icons:5.5.0-pre.314-kotlin-1.6.10")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion:11.7.1-pre.314-kotlin-1.6.10")

    // Kotlin Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")

    // @emotion
    implementation(npm("@emotion/react", "11.8.1"))
    implementation(npm("@emotion/styled", "11.8.0"))
}

kotlin {
    js(LEGACY) {
        binaries.executable()
        browser {
//            runTask{
//                devServer=org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig.DevServer(
//                    port= 3000,
//                    proxy = mutableMapOf("/api" to mapOf("target" to "http://localhost:8080")),
//                    contentBase = mutableListOf("$buildDir/processedResources/js/main")
//                )
//            }
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
}