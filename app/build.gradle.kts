import convention.CoachBuildType

plugins {
    libs.plugins.coach.run {
        alias(android.application)
        alias(android.application.compose)
        alias(android.di)
        alias(android.room)
    }
}
android {
    buildFeatures {
        buildConfig = true
    }
    buildTypes {
        debug {
            applicationIdSuffix = CoachBuildType.DEBUG.applicationIdSuffix
        }
        val release by getting {
            isMinifyEnabled = true
            isShrinkResources = true
            applicationIdSuffix = CoachBuildType.RELEASE.applicationIdSuffix
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}
dependencies {
    libs.run {
        implementation(androidx.core.splashscreen)
        implementation(androidx.constraintlayout)
        implementation(timber)
        implementation(kotlinx.collections.immutable)
        implementation(accompanist.permissions)
    }
}
