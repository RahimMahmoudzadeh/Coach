
package convention

/**
 * This is shared between :app and :benchmarks module to provide configurations type safety.
 */
enum class CoachBuildType(val applicationIdSuffix: String? = null) {
    DEBUG(".debug"),
    RELEASE,
}
