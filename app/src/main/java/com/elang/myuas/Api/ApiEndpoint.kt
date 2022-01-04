package com.elang.myuas.Api

import com.elang.myuas.Model.CatatanModel
import com.elang.myuas.Model.ResponseLogin
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiEndpoint {
    @GET("data.php")
    fun data() :Call<CatatanModel>

    @FormUrlEncoded
    @POST("login.php")
    fun login(
        @Field("post_nim") nim : String,
        @Field("post_password") password :String
    ): Call<ResponseLogin>
}