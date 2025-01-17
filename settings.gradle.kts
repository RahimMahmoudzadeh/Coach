gradle.startParameter.excludedTaskNames.addAll(listOf(":build-logic:convention:testClasses"))
pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Coach"

private fun subprojects(path: String) =
    file(path)
        .listFiles()
        .filter {
            it.isDirectory && it.listFiles().any { file -> file.name == "build.gradle.kts" }
        }.map {
            "${path.replace('/', ':')}:${it.name}"
        }
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(
    ":app",
)
include(subprojects("data"))
include(subprojects("domain"))
include(subprojects("feature"))
include(subprojects("library"))
include(subprojects("core"))
