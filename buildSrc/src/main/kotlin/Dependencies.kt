object Plugins {
    object AGP {
        const val application = "com.android.application"
        const val library = "com.android.library"
    }

    object Kotlin {
        const val android = "org.jetbrains.kotlin.android"
        const val jvm = "org.jetbrains.kotlin.jvm"
        const val kapt = "kotlin-kapt"
    }

    object DaggerHilt {
        const val hilt = "com.google.dagger.hilt.android"
    }

}

object Dependencies {

    object UI {
        const val core = ("androidx.core:core-ktx:${Version.core}")
        const val appcompat = ("androidx.appcompat:appcompat:${Version.appcompat}")
        const val material = ("com.google.android.material:material:${Version.material}")
        const val constraintLayout =
            ("androidx.constraintlayout:constraintlayout:${Version.constraintLayout}")
        const val lifecycleViewModel =
            ("androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycleViewModel}")

    }

    object Room {
        const val runtime =("androidx.room:room-runtime:${Version.room}")
        const val ktx =("androidx.room:room-runtime:${Version.room}")
        const val kapt = ("androidx.room:room-compiler:${Version.room}")
    }

    object DaggerHilt {

        const val android = ("com.google.dagger:hilt-android:${Version.hilt}")
        const val kapt = ("com.google.dagger:hilt-compiler:${Version.hilt}")
    }

    object Coroutine {

        const val android =("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutine}")
    }

    object Nav {

        const val fragment = ("androidx.navigation:navigation-fragment-ktx:${Version.navigation}")
        const val uiKtx = ("androidx.navigation:navigation-fragment-ktx:${Version.navigation}")
    }

    object Test {
        const val junit = ("junit:junit:${Version.testJunit}")
        const val extJunit = ("androidx.test.ext:junit:${Version.testExtJunit}")
        const val espressoCore = ("androidx.test.espresso:espresso-core:${Version.testEspresso}")
    }

}

object Version {

    const val core = "1.7.0"
    const val appcompat = "1.6.1"
    const val material = "1.8.0"
    const val constraintLayout = "2.1.4"
    const val lifecycleViewModel = "2.5.1"

    const val AGP = "7.2.1"
    const val kotlin = "1.6.10"
    const val daggerHilt = "2.44"

    const val room = "2.5.0"

    const val hilt = "2.45"

    const val coroutine = "1.6.4"

    const val navigation = "2.5.3"

    const val testJunit = "4.13.2"

    const val testExtJunit = "1.1.5"

    const val testEspresso = "3.5.1"

}