package com.rlibanez.mrbeam.client

import com.rlibanez.mrbeam.service.SectionService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL = "https://metalcompendium.duckdns.org/api/"

    val sectionClient: SectionService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SectionService::class.java)
    }

}