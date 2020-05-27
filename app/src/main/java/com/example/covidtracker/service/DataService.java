package com.example.covidtracker.service;

import com.example.covidtracker.model.AddressResult;
import com.example.covidtracker.model.DistrictResult;
import com.example.covidtracker.model.StateResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface DataService {
    @GET("data.json")
    Call<StateResult> getStateData();

    @GET("v2/state_district_wise.json")
    Call<List<DistrictResult>> getDistrictData();

    @GET
    Call<AddressResult> getAddress(@Url String url);

}
