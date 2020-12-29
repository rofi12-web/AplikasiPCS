package com.sportapp.remote

import retrofit2.Call
import com.sportapp.data.model.NewsList
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("api/amiibo/?character=zelda")
    fun listNews() : Call<NewsList>

    @GET("detail")
    fun detailNews(@Query("url") url: String) : Call<NewsList>

    @GET( "search")
    fun searchNews(@Query("q") query : String) : Call<NewsList>

}