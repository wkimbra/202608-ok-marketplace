

rootProject.name = "ok-myproject-be"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

pluginManagement {
    includeBuild("../build-plugin")


}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
