package com.devanshu.physicswallahassignment

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("easygautam/data/users")
    fun getData(): Call<List<MyDataItem>>
}