package convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.ProductFlavor
import config.Config

@Suppress("EnumEntryName")
enum class FlavorDimension {
  contentType
}

@Suppress("EnumEntryName")
enum class CoachFlavor(
  val dimension: FlavorDimension,
  val applicationIdSuffix: String? = null,
  val versionNameSuffix: String,
) {
  googlePlay(FlavorDimension.contentType, applicationIdSuffix = Config.android.applicationIdSuffix, versionNameSuffix = Config.android.versionNameSuffixGooglePlay),
  cafeBazaar(FlavorDimension.contentType, applicationIdSuffix = Config.android.applicationIdSuffix, versionNameSuffix = Config.android.versionNameSuffixCafeBazaar),
  myket(FlavorDimension.contentType, applicationIdSuffix = Config.android.applicationIdSuffix, versionNameSuffix = Config.android.versionNameSuffixMyket),
}

internal fun configureFlavors(
  commonExtension: CommonExtension<*, *, *, *, *, *>,
  flavorConfigurationBlock: ProductFlavor.(flavor: CoachFlavor) -> Unit = {},
) {
  commonExtension.apply {
    flavorDimensions += FlavorDimension.contentType.name
    productFlavors {
      CoachFlavor.values().forEach {
        create(it.name) {
          manifestPlaceholders += if (it == CoachFlavor.cafeBazaar || it == CoachFlavor.myket) {
            mapOf("queryAllPackages" to "android.permission.QUERY_ALL_PACKAGES")
          }else{
            mapOf("queryAllPackages" to "false")
          }
          dimension = it.dimension.name
          flavorConfigurationBlock(this, it)
          if (this@apply is ApplicationExtension && this is ApplicationProductFlavor) {
            if (it.applicationIdSuffix != null) {
              applicationIdSuffix = it.applicationIdSuffix
            }
            versionNameSuffix = it.versionNameSuffix
          }
        }
      }
    }
  }
}
