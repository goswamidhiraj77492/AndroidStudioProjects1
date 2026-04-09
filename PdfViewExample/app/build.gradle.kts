plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.pdfviewexample"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.pdfviewexample"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("com.github.barteksc:android-pdf-viewer:2.8.2")
        // Replace 'latest-version' with the actual latest version number
        implementation ("io.github.afreakyelf:Pdf-Viewer:latest-version")


}