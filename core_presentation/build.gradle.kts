/**
 * Only reusable base classes to use in the presentation layer (eg: BaseViewModel )
 * NO composable views
 **/
plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = AppConfig.compileSdkVersion


    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeVersion
    }
    namespace = "com.emmanuelguther.core_presentation"
}

dependencies {
    implementation(dependencyCoreKtx)
    implementation(dependencyLifecycleViewModel)
    dependenciesCoroutines()
    dependenciesUI()
}

