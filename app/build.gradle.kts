plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")

}

android {
    namespace = "com.example.fidotest"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.fidotest"
        minSdk = 24
        targetSdk = 36
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
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}


dependencies {
    // testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2025.06.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Kotlin & Core
    implementation("androidx.core:core-ktx:1.16.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.9.1")
    implementation("androidx.activity:activity-compose:1.10.1")
    implementation(platform("androidx.compose:compose-bom:2025.06.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")


    // ViewModel + Lifecycle
    val viewModelVer = "2.9.1"
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$viewModelVer")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$viewModelVer")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:$viewModelVer")

    // Coroutines + Flow
    val flowVer = "1.8.1"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$flowVer")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$flowVer")

    // Retrofit + Gson
    val retroVer = "2.11.0"
    implementation("com.squareup.retrofit2:retrofit:$retroVer")
    implementation("com.squareup.retrofit2:converter-gson:$retroVer")

    // Room
    val roomVer = "2.7.1"
    implementation("androidx.room:room-runtime:$roomVer")
    kapt("androidx.room:room-compiler:$roomVer")
    implementation("androidx.room:room-ktx:$roomVer")

    // Koin (DI)
    val koinVer = "3.5.6"
    implementation("io.insert-koin:koin-android:$koinVer")
    implementation("io.insert-koin:koin-androidx-compose:$koinVer")

    // Navigation Compose
    val navVer = "2.9.0"
    implementation("androidx.navigation:navigation-compose:$navVer")

    val coilImageVer = "3.2.0"
    implementation("io.coil-kt.coil3:coil-compose:$coilImageVer")
    implementation("io.coil-kt.coil3:coil-network-okhttp:$coilImageVer")
}