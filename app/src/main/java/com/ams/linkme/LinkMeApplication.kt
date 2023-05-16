package com.ams.linkme

import android.app.Application
import com.ams.linkme.networking.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.ams.linkme.utils.Constants

class LinkMeApplication : Application() {

    lateinit var apiService: ApiService

    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }
}
