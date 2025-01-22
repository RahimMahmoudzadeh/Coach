plugins {
    libs.plugins.coach.run {
        alias(android.library)
        alias(android.di)
        alias(android.library.compose)
    }
}

android {
    namespace = "com.rahim.coach.core.base"
}

dependencies {
    libs.run {
        implementation(androidx.datastore.preferences)
        implementation(androidx.datastore.preferences.core)
    }
}
