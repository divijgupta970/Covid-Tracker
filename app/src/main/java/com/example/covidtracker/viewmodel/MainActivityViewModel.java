package com.example.covidtracker.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.covidtracker.model.DistrictWise;
import com.example.covidtracker.model.Statewise;

public class MainActivityViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<Statewise> stateData;
    private LiveData<Statewise> countryData;
    private LiveData<DistrictWise> districtWiseData;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
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


}
