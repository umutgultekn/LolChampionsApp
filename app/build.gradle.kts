plugins {
    id(PluginSpecScope.application)
    id(PluginSpecScope.android)
    id(PluginSpecScope.kapt)
    id(PluginSpecScope.hilt)
    id(PluginSpecScope.navigationSafeargsKotlin)
    id(PluginSpecScope.parcelize)
}

android {
    namespace = ConfigData.namespace
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = ConfigData.applicationId
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = ConfigData.testInstrumentationRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    implementation(Deps.legacySupport)
    implementation(Deps.lifecycleViewModel)
    implementation ("com.google.android.gms:play-services-maps:17.0.0")
    implementation ("com.google.android.gms:play-services-location:18.0.0")
    implementation ("com.google.maps.android:android-maps-utils:1.1.0")

    //tests
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.junitTest)
    androidTestImplementation(Deps.espresso)

    //androidx
    implementation(Deps.core)
    implementation(Deps.appCompat)
    implementation(Deps.constraintLayout)
    implementation(Deps.navigationFragment)
    implementation(Deps.navigationUI)
    implementation(Deps.lifecycleLiveData)

    //coroutines
    implementation(Deps.coroutines)

    //material
    implementation(Deps.material)

    //dependency injection
    implementation(Deps.hilt)
    kapt(Deps.hiltCompiler)

    //networking
    implementation(Deps.retrofit)
    implementation(Deps.retrofitConverterGson)

    //persistence
    implementation(Deps.room)
    annotationProcessor(Deps.roomCompiler)
    kapt(Deps.roomCompiler)

    // image
    implementation(Deps.glide)
    kapt(Deps.glideCompiler)

    // timber
    implementation(Deps.timber)

    // splash screen
    implementation(Deps.splashScreen)

    // shimmer
    implementation(Deps.shimmer)
}