plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.pdfcomprssion"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.pdfcomprssion"
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

    // iText 7 dependencies
    implementation("com.itextpdf:kernel:7.2.3")
    implementation("com.itextpdf:io:7.2.3")
    implementation("com.itextpdf:layout:7.2.3")
    implementation("com.itextpdf:forms:7.2.3")
    implementation("com.itextpdf:pdfa:7.2.3")
}
