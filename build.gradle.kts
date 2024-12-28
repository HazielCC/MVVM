// Top-level build file where you can add configuration options common to all sub-projects/modules.
// Archivo de compilación a nivel superior donde puedes añadir opciones de configuración comunes
// a todos los subproyectos/módulos.
plugins {
    // Alias para el plugin de aplicación Android, no se aplica automáticamente.
    alias(libs.plugins.android.application) apply false
    // Alias para el plugin de Kotlin para Android, no se aplica automáticamente.
    alias(libs.plugins.kotlin.android) apply false
    // Alias para el plugin de Hilt (inyección de dependencias), no se aplica automáticamente.
    alias(libs.plugins.hilt.android) apply false
    // Alias para el plugin KSP (Kotlin Symbol Processing), no se aplica automáticamente.
    alias(libs.plugins.ksp) apply false
}

/*
* Android Application Plugin (com.android.application):
* Proporciona tareas y configuraciones específicas para aplicaciones Android,
* como la compilación de código fuente, empaquetado de aplicaciones APK, y gestión de recursos y dependencias.

* Kotlin Android Plugin (org.jetbrains.kotlin.android):
* Permite compilar código Kotlin, así como integrar características de Kotlin como extensiones y coroutines
*
* Hilt Android Plugin (com.google.dagger.hilt.android):
* Este plugin facilita la configuración de Hilt en proyectos Android.
* Simplifica la inyección de dependencias proporcionando anotaciones, mejorando la modularidad y testabilidad del código.

* Kotlin Symbol Processing Plugin (com.google.devtools.ksp):
* KSP (Kotlin Symbol Processing). Facilita la generación de código basado en anotaciones en tiempo de compilación.
* Es una alternativa a kapt (Kotlin Annotation Processing Tool) y está optimizado para funcionar con Kotlin.
* */
