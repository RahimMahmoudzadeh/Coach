plugins {
    libs.plugins.coach.run {
        alias(android.library)
        alias(android.library.compose)
    }
}

android {
    namespace = "com.rahim.coach.library.navigation"
}
dependencies {
    implementation(projects.library.designsystem)
}
