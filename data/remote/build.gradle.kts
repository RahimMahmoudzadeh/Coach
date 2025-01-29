plugins {
    libs.plugins.coach.run {
        alias(android.library)
        alias(android.di)
    }
}

android {
    namespace = "com.rahim.coach.data.remote"
}

dependencies {
    implementation(libs.bundles.ktor)
}

