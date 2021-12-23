plugins {
    id("com.android.library")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
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
    namespace = "com.emmanuelguther.features"
}

dependencies {
    implementation(project(":commons"))
    implementation(project(":core_presentation"))
    implementation(project(":domain"))
    dependenciesUI()
    dependenciesHilt()
    implementation("io.coil-kt:coil-compose:1.4.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")

    testImplementation ("junit:junit:4.13.2")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.2")
}
