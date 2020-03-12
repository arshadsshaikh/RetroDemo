package com.example.retrodemo

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("users?page=1")
    fun doGetListResources(): Call<DemoModel?>?
}