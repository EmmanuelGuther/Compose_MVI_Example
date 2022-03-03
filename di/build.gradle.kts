plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = AppConfig.compileSdkVersion
    namespace = "com.emmanuelguther.di"
}

dependencies {
    dependenciesHilt()
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation ("com.google.firebase:firebase-storage-ktx:20.0.0")
}