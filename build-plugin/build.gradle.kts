import org.jetbrains.kotlin.js.sourceMap.SourceFilePathResolver.Companion.create

/*plugins {
    kotlin("jvm") version "2.4.20"
}

group = "ru.otus.otuskotlin"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}*/

plugins {
    `kotlin-dsl`
}

dependencies {

    implementation(libs.plugin.kotlin)
    //implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.4.20")
    //implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.20")
}
repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("BuildPluginJvm") {
            id = "ru.otus.otuskotlin.marketplace.jvm"
            implementationClass = "ru.otus.otuskotlin.marketplace.plugin.BuildPluginJvm"
        }
        create("BuildPluginMultiplatform") {
            id = "ru.otus.otuskotlin.marketplace.kmp"
            implementationClass = "ru.otus.otuskotlin.marketplace.plugin.BuildPluginMultiplatform"
        }
    }
}
