plugins {
    libs.plugins.coach.run {
        alias(android.feature)
        alias(android.library.compose)
    }
}

android {
    namespace = "com.rahim.coach.feature.home"
}