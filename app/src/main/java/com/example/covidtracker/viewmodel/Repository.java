package com.example.covidtracker.viewmodel;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.covidtracker.model.DistrictResult;
import com.example.covidtracker.model.DistrictWise;
import com.example.covidtracker.model.StateResult;
import com.example.covidtracker.model.Statewise;
import com.example.covidtracker.service.DataService;
import com.example.covidtracker.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private List<Statewise> statewiseList = new ArrayList<>();
    private MutableLiveData<Statewise> statewiseMutableLiveData = new MutableLiveData<>();
    private List<DistrictWise> districtWiseList = new ArrayList<>();
    private MutableLiveData<DistrictWise> districtWiseMutableLiveData = new MutableLiveData<>();
    private Application application;

    public Repository(Application application) {
        this.application = application;
    }

    public MutableLiveData<Statewise> getStateData(final String state) {

        DataService dataService = RetrofitInstance.getService();
        Call<StateResult> call = dataService.getStateData();
        call.enqueue(new Callback<StateResult>() {
            @Override
            public void onResponse(Call<StateResult> call, Response<StateResult> response) {
                StateResult stateResult = response.body();
                if (stateResult != null && stateResult.getStatewise() != null) {
                    statewiseList = stateResult.getStatewise();
                    for (Statewise s : statewiseList)
                        if (s.getState().toLowerCase().equals(state)) {
                            statewiseMutableLiveData.setValue(s);
                            break;
                        }
                }
            }

            @Override
            public void onFailure(Call<StateResult> call, Throwable t) {

            }
        });
        return statewiseMutableLiveData;
    }

    public MutableLiveData<DistrictWise> getDistrictData(final String state, final String district) {
        DataService dataService = RetrofitInstance.getService();
        Call<List<DistrictResult>> call = dataService.getDistrictData();
        call.enqueue(new Callback<List<DistrictResult>>() {
            @Override
            public void onResponse(Call<List<DistrictResult>> call, Response<List<DistrictResult>> response) {
                List<DistrictResult> districtResultList = response.body();
                if (districtResultList != null && !districtResultList.isEmpty()) {
                    Comparator<DistrictResult> c = new Comparator<DistrictResult>() {
                        @Override
                        public int compare(DistrictResult o1, DistrictResult o2) {
                            return o1.getState().toLowerCase().compareTo(o2.getState().toLowerCase());
                        }
                    };
                    int ind = Collections.binarySearch(districtResultList, new DistrictResult(state), c);
                    if (ind >= 0) {
                        districtWiseList = districtResultList.get(ind).getDistrictData();
                        Comparator<DistrictWise> c2 = new Comparator<DistrictWise>() {
                            @Override
                            public int compare(DistrictWise o1, DistrictWise o2) {
                                return o1.getDistrict().toLowerCase().compareTo(o2.getDistrict().toLowerCase());
                            }
                        };
                        int distInd = Collections.binarySearch(districtWiseList, new DistrictWise(district), c2);
                        if (distInd >= 0)
                            districtWiseMutableLiveData.setValue(districtWiseList.get(distInd));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<DistrictResult>> call, Throwable t) {

            }
        });
        return districtWiseMutableLiveData;
    }
}
