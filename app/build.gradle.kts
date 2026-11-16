plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "educa.iesam.marvelapp"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "educa.iesam.marvelapp"
        minSdk = 26
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    // Librerías implementadas por mí
    implementation(libs.gson)
    implementation(libs.kotlinSerializationJson)
    testImplementation(libs.mockkAgent)
    testImplementation(libs.mockkAndroid)
    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}