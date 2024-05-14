plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
//    alias(libs.plugins.daggerHilt)
}

android {
    namespace = "com.kelvin.catalogue"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.kelvin.catalogue"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources.excludes.addAll(
            listOf(
//                "META-INF/LICENSE.md",
//                "META-INF/LICENSE-notice.md",
//                "META-INF/gradle/incremental.annotation.processors",
//                "/META-INF/{AL2.0,LGPL2.1}"
            )
        )
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
//    implementation(libs.androidx.material3)
    implementation(libs.androidx.material)
    implementation(libs.android.hilt.navigation)
    implementation(libs.android.hilt.navigation.fragment)
    implementation(libs.androidx.nav.compose)

    //hilt
    kapt(libs.hilt.compiler)
    kapt(libs.androidx.hilt.compiler)
    implementation(libs.android.hilt)

    //retrofit
    implementation(libs.okhttp.retrofit)
    implementation(libs.okhttp.converter)
    implementation(libs.okhttp.interceptor)

    //room
    implementation(libs.room.runtime)
    annotationProcessor(libs.room.compiler)
    implementation(libs.room.ktx)
    kapt(libs.room.persistance)
}