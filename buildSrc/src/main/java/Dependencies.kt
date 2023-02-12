object PluginSpecScope {

    const val navigationSafeargs = "androidx.navigation.safeargs"
    const val library = "com.android.library"
    const val application = "com.android.application"
    const val android = "org.jetbrains.kotlin.android"
    const val kapt = "kotlin-kapt"
    const val hilt = "com.google.dagger.hilt.android"
    const val navigationSafeargsKotlin = "androidx.navigation.safeargs.kotlin"
    const val parcelize = "kotlin-parcelize"

}

object BuildPlugins {

    const val androidGradle = "com.android.tools.build:gradle:${Versions.androidGradle}"
    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradlePlugin}"
    const val hiltGradlePlugin =
        "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltGradlePlugin}"
}

object Deps {

    const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacySupport}"
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModel}"
    const val junit = "junit:junit:${Versions.junit}"
    const val junitTest = "androidx.test.ext:junit:${Versions.junitTest}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigationFragment}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigationUI}"
    const val lifecycleLiveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleLiveData}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hiltCompiler}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverterGson =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofitConverterGson}"
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomCompiler}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glideCompiler}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val splashScreen = "androidx.core:core-splashscreen:${Versions.splashScreen}"
    const val shimmer = "com.facebook.shimmer:shimmer:${Versions.shimmer}"
}

object ConfigData {

    const val applicationId = "com.umutg.lolchampionsapp"
    const val minSdkVersion = 21
    const val targetSdkVersion = 33
    const val compileSdkVersion = 33
    const val versionCode = 1
    const val versionName = "1.0"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val namespace = "com.umutg.lolchampionsapp"
}