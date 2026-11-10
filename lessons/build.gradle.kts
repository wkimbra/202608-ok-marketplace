/*plugins {
    kotlin("jvm") version "2.4.20"
}*/

plugins {
    kotlin("jvm") apply false
}

group = "ru.otus.otuskotlin"
version = "0.0.1"

repositories {
    mavenCentral()
}

subprojects {
    repositories {
        mavenCentral()
    }
    group = rootProject.group
    version = rootProject.version
}