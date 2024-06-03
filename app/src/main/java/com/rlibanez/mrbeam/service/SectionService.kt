package com.rlibanez.mrbeam.service

import com.rlibanez.mrbeam.model.Section
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SectionService {

    @GET("sections")
    suspend fun getSectionsByContainingName(@Query("contain") contain: String): Response<List<Section>>

}