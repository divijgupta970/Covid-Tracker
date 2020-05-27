package com.example.covidtracker.service;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ScalarDataService {
    @GET("districts_daily.json")
    Call<String> getDailyChangesDistrict();

    @GET("states_daily.json")
    Call<String> getDailyChangesState();
}
