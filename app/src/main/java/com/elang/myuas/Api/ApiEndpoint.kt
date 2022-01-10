package com.elang.myuas.Api

import com.elang.myuas.Model.CatatanModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiEndpoint {
    @GET("data.php")
    fun data() :Call<CatatanModel>
}