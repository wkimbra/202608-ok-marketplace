package ru.otus.otuskotlin.marketplace.plugin
///Users/gimadeevbulat/otus/otuskotlin/202608-ok-marketplace/build-plugin/src/main/kotlin/BuildPluginJVM.kt

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class BuildPluginJvm : Plugin<Project> {
    override fun apply(target: Project) = with(target) {

        pluginManager.apply("org.jetbrains.kotlin.jvm")


        repositories.mavenCentral()


        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")


        dependencies {
            val datetimeLib = libs.findLibrary("kotlinx-datetime").orElseThrow {
                NoSuchElementException("Библиотека 'kotlinx-datetime' не найдена в libs.versions.toml")
            }
            add("implementation", datetimeLib)
        }
    }
}
