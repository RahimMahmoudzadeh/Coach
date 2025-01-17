plugins {
    libs.plugins.coach.run {
        alias(android.library)
        alias(android.library.compose)
    }
}

android {
    namespace = "com.rahim.coach.library.designsystem"
}
dependencies {
    implementation(projects.core.base)
    libs.run {
        implementation(accompanist.permissions)
        implementation(swipe)
    }
}
