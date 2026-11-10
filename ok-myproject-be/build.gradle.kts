plugins {
    alias(libs.plugins.kotlin.jvm) //apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
}

repositories {
    mavenCentral()
}

group = "ru.otus.otuskotlin"
version = "0.0.1"



dependencies {
    implementation(libs.kotlinx.datetime)
}

