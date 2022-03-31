package com.example.championsleague.net

import android.util.Log
import com.example.championsleague.BuildConfig
import com.example.championsleague.tools.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    val retrofitAdapter: Retrofit
        get() {
            val client = OkHttpClient.Builder()
            if (BuildConfig.DEBUG) {
                val httpLoggingInterceptor = HttpLoggingInterceptor { message ->
                    Log.d(
                        Constants.APP_TAG_NETWORK,
                        message
                    )
                }
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                client.addInterceptor(httpLoggingInterceptor)
            }
            return Retrofit.Builder()
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .build()
        }
}