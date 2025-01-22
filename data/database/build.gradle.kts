plugins {
    libs.plugins.coach.run {
        alias(android.library)
        alias(android.di)
        alias(android.room)
    }
}

android {
    namespace = "com.rahim.coach.data.database"
}

dependencies {
    for (module in projects.domain) implementation(module)
}
private operator fun ProjectDependency.iterator() =
    object : Iterator<ProjectDependency> {
        var moduleCount = this@iterator::class.java.declaredMethods.size

        override fun hasNext(): Boolean = moduleCount-- != 0

        override fun next(): ProjectDependency =
            this@iterator::class.java.declaredMethods[moduleCount].invoke(
                this@iterator,
            ) as ProjectDependency
    }
