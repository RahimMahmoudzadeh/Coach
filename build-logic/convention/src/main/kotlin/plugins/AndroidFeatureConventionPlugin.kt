package plugins

import androidGradle
import applyPlugins
import versionCatalog
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            applyPlugins {
                listOf("coach.android.library", "coach.android.di")
            }
            dependencies {
                add("implementation", versionCatalog.findLibrary("androidx.tracing.ktx").get())
                add("api", project(":library:designsystem"))
                add("api", project(":library:navigation"))
                add("api", project(":core:base"))
            }
        }
    }
}
