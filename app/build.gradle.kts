plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    ///ksp///
    id("com.google.devtools.ksp")

    //god help us ///
    id ("kotlin-parcelize")
    id("com.google.gms.google-services")

}

android {
    namespace = "com.example.borrowbee"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.borrowbee"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    ksp {
        arg("room.schemaLocation", "$projectDir/schemas")
    }
}



dependencies {



    implementation ("com.google.android.material:material:1.12.0")


    implementation ("com.github.bumptech.glide:glide:4.13.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.firebase:firebase-firestore:25.0.0")
    implementation("com.google.firebase:firebase-auth:23.0.0")
    implementation("com.google.android.gms:play-services-auth:21.1.1")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    implementation("com.google.firebase:firebase-crashlytics-buildtools:3.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.13.0")


    //KSP
    annotationProcessor("com.google.dagger:dagger-compiler:2.51.1")
    ksp("com.google.dagger:dagger-compiler:2.51.1")


    val nav_version = "2.7.7"
    val room_version = "2.6.1"

    implementation ("androidx.room:room-runtime:$room_version")
    //Room
    ksp("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:$room_version")



    ///////Compose//////
    implementation ("androidx.navigation:navigation-compose:$nav_version")
    ///////////////////


    ///////MAT3////////
    implementation("androidx.compose.material3:material3-adaptive-navigation-suite-android:1.0.0-alpha07")
    implementation ("androidx.compose.material3:material3:1.2.1")
    /////////////////

    /////more icons////
    implementation("androidx.compose.material:material-icons-extended")


    //implementation("androidx.credentials:credentials:1.3.0-alpha03")


    implementation("androidx.core:core-ktx:1.13.1")

    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2024.05.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.05.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")


    ///Fierbace
    implementation ("com.google.firebase:firebase-core:21.1.1")
    implementation ("com.google.firebase:firebase-database:21.0.0")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")

    implementation("io.coil-kt:coil-compose:2.4.0")

    //implementation("com.google.android.gms:play-services-credentials:21.1.1")

    //implementation("google.dagger:hilt-android:2.47")
    //ksp("com.google.dagger:hilt-android-compiler:2.47")
    //ksp("androidx.hilt:hilt-compiler:1.2.0")
    //implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
}