package com.flauraha.ari.data.remote

import com.flauraha.ari.data.model.Volumes
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApiService {

    @GET("volumes")
    suspend fun listBooks(@Query("q") searchText: String): Volumes
}