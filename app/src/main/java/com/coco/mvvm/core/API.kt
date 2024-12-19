package com.coco.mvvm.core

/*
object API {
    // Instancia de Retrofit
    @Volatile
    private var retrofit: Retrofit? = null

    // Obtener instancia de Retrofit
    fun getRetrofit(): Retrofit {
        return retrofit ?: synchronized(this) { retrofit ?: buildRetrofit().also { retrofit = it } }
    }

    // Construcción de Retrofit
    private fun buildRetrofit(): Retrofit { // Logging interceptor
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://qapi.vercel.app/api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}*/
