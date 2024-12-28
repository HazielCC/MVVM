plugins {
    // Alias para el plugin de aplicación Android.
    alias(libs.plugins.android.application)
    // Alias para el plugin de Kotlin para Android.
    alias(libs.plugins.kotlin.android)
    // Alias para el plugin KSP (Kotlin Symbol Processing).
    alias(libs.plugins.ksp)
    // Alias para el plugin de Hilt para la inyección de dependencias en Android.
    alias(libs.plugins.hilt.android)
    // Plugin para procesamiento de anotaciones en Kotlin (kapt).
    id("kotlin-kapt") // Kotlin annotation processing
}

android {
    namespace = "com.coco.mvvm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.coco.mvvm"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Dependencias para Retrofit
    implementation(libs.retrofit) // Biblioteca principal de Retrofit para llamadas de red.
    implementation(libs.converter.gson) // Convertidor Gson para Retrofit.
    implementation(libs.logging.interceptor) // Interceptor de logging para Retrofit.

    // Dependencias para Corrutinas
    implementation(libs.kotlinx.coroutines.android) // Biblioteca de corutinas para Android.

    // Componentes del ciclo de vida de Android
    implementation(libs.androidx.lifecycle.viewmodel.ktx) // ViewModel KTX para ciclo de vida.
    implementation(libs.androidx.lifecycle.livedata.ktx) // LiveData KTX para ciclo de vida.

    // Dependencias para Dagger Hilt
    implementation(libs.hilt.android) // Biblioteca principal de Hilt.
    ksp(libs.hilt.android.compiler) // Compilador para Hilt.

    // Dependencias para Room
    implementation(libs.androidx.room.ktx) // Biblioteca KTX para Room.
    ksp(libs.androidx.room.compiler) // Compilador para Room.

    // Dependencias adicionales
    implementation(libs.androidx.core.ktx) // Biblioteca core KTX para Android.
    implementation(libs.androidx.appcompat) // Biblioteca AppCompat para compatibilidad hacia atrás.
    implementation(libs.material) // Componentes de Material Design.
    implementation(libs.androidx.activity) // Biblioteca de Activity KTX para Android.
    implementation(libs.androidx.constraintlayout) // Biblioteca para ConstraintLayout.

    // Dependencias para pruebas
    testImplementation(libs.junit) // JUnit para pruebas unitarias.
    testImplementation(libs.mockk) // MockK para mocks en Kotlin.
    testImplementation(libs.androidx.core.testing) // Biblioteca de pruebas core para Android.
    androidTestImplementation(libs.androidx.junit) // JUnit para pruebas de instrumentación.
    androidTestImplementation(libs.androidx.espresso.core) // Espresso para pruebas de UI.

}