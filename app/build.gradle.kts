plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.meal-mate" // Replace with your actual package name
    compileSdk = 34 // Or your target SDK version

    defaultConfig {
        applicationId = "com.example.meal-mate" // Replace with your actual package name
        minSdk = 24 // Or your minimum SDK version
        //noinspection OldTargetApi
        targetSdk = 34 // Or your target SDK version
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        viewBinding = true  // Enable view binding if you are using it
    }
}

dependencies {

    //noinspection GradleDependency
    implementation("androidx.core:core-ktx:1.12.0") // Or the latest version
    //noinspection GradleDependency
    implementation("androidx.appcompat:appcompat:1.6.1") // Or the latest version
    //noinspection GradleDependency
    implementation("com.google.android.material:material:1.11.0") // Or the latest version
    //noinspection GradleDependency
    implementation("androidx.constraintlayout:constraintlayout:2.1.4") // Or the latest version
    testImplementation("junit:junit:4.13.2")
    //noinspection GradleDependency
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    //noinspection GradleDependency
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}