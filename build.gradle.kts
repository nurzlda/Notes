// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id (Plugins.AGP.application) version Version.AGP apply false
    id (Plugins.AGP.library) version Version.AGP apply false
    id (Plugins.Kotlin.android) version Version.kotlin apply false
    id (Plugins.DaggerHilt.hilt) version Version.daggerHilt apply false
    id (Plugins.Kotlin.jvm) version Version.kotlin apply false
}
