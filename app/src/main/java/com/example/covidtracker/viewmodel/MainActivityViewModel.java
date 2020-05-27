package com.example.covidtracker.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.covidtracker.model.Address;
import com.example.covidtracker.model.ChartData;
import com.example.covidtracker.model.DistrictWise;
import com.example.covidtracker.model.Statewise;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<Address> address;
    private LiveData<Statewise> stateData;
    private LiveData<Statewise> countryData;
    private LiveData<DistrictWise> districtWiseData;
    private LiveData<List<ChartData>> stateChartData;
    private LiveData<List<ChartData>> districtChartData;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }


    public LiveData<Address> getAddress(String url, boolean isRefresh) {
        if (isRefresh || address == null)
            address = repository.getAddress(url);
        return address;
    }


    public LiveData<Statewise> getStateData(String state, boolean isRefresh) {
        if (stateData == null || isRefresh) {
            stateData = repository.getStateData(state);
        }
        return stateData;
    }

    public LiveData<Statewise> getCountryData(boolean isRefresh) {
        if (countryData == null || isRefresh) {
            countryData = repository.getStateData("total");
        }
        return countryData;
    }

    public LiveData<DistrictWise> getDistrictWiseData(String state, String district, boolean isRefresh) {
        if (districtWiseData == null || isRefresh) {
            districtWiseData = repository.getDistrictData(state, district);
        }
        return districtWiseData;
    }

    public LiveData<List<ChartData>> getStateChartData(String state, boolean isRefresh) {
        if (stateChartData == null || isRefresh) {
            stateChartData = repository.getStateChartData(state);
        }
        return stateChartData;
    }

    public LiveData<List<ChartData>> getDistrictChartData(String state, String district, boolean isRefresh) {
        if (districtChartData == null || isRefresh) {
            districtChartData = repository.getDistrictChartData(state, district);
        }
        return districtChartData;
    }


}
