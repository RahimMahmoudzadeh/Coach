plugins {
    libs.plugins.coach.run {
        alias(android.library)
        alias(android.room)
    }
}

android {
    namespace = "com.rahim.coach.domin.home"
}

dependencies{
    implementation(projects.core.base)
}