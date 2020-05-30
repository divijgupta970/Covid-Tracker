package com.example.covidtracker.service;

import android.content.Context;

import com.example.covidtracker.util.Constants;
import com.example.covidtracker.util.Util;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit = null;

    public static DataService getService(Context context) {


        if (retrofit == null) {

            long cacheSize = 5 * 1024 * 1024;
            Cache myCache = new Cache(context.getCacheDir(), cacheSize);

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .cache(myCache)
                    .addInterceptor(chain -> {
                        Request request = chain.request();
                        if (Util.isNetworkConnected(context) && Util.isInternetAvailable()) {
                            request = request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build();
                        } else {
                            request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build();
                        }
                        return chain.proceed(request);
                    }).build();

            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        return retrofit.create(DataService.class);

    }

}
