package com.example.covidtracker.service;

import com.example.covidtracker.util.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ScalarRetrofitInstance {
    private static Retrofit retrofit = null;

    public static ScalarDataService getService() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();

        }
        return retrofit.create(ScalarDataService.class);
    }
}
