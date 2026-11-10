package ru.otus.otuskotlin.marketplace.plugin



import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

@Suppress("unused")
class BuildPluginMultiplatform : Plugin<Project> {
    override fun apply(target: Project) = with(target) {

        pluginManager.apply("org.jetbrains.kotlin.multiplatform")


        repositories.mavenCentral()


        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")


        (this as ExtensionAware).extensions.configure(KotlinMultiplatformExtension::class.java) {

            jvm()


            sourceSets.getByName("commonMain").dependencies {
                val datetimeLib = libs.findLibrary("kotlinx-datetime").orElseThrow {
                    NoSuchElementException("Библиотека 'kotlinx-datetime' не найдена в libs.versions.toml")
                }
                implementation(datetimeLib)
            }
        }
    }
}
