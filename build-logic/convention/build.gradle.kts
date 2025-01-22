import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "coach.android.application.compose"
            implementationClass = "plugins.AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "coach.android.application"
            implementationClass = "plugins.AndroidApplicationConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "coach.android.library.compose"
            implementationClass = "plugins.AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "coach.android.library"
            implementationClass = "plugins.AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "coach.android.feature"
            implementationClass = "plugins.AndroidFeatureConventionPlugin"
        }
        register("androidKoin") {
            id = "coach.android.di"
            implementationClass = "plugins.AndroidKoinConventionPlugin"
        }
        register("androidRoom") {
            id = "coach.android.room"
            implementationClass = "plugins.AndroidRoomConventionPlugin"
        }
    }
}
