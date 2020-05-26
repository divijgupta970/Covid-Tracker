package com.example.covidtracker.viewmodel;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.covidtracker.model.Address;
import com.example.covidtracker.model.AddressResult;
import com.example.covidtracker.model.ChartData;
import com.example.covidtracker.model.DistrictResult;
import com.example.covidtracker.model.DistrictWise;
import com.example.covidtracker.model.StateResult;
import com.example.covidtracker.model.StatesDaily;
import com.example.covidtracker.model.StatesDailyResult;
import com.example.covidtracker.model.Statewise;
import com.example.covidtracker.service.DataService;
import com.example.covidtracker.service.RetrofitInstance;
import com.example.covidtracker.util.Util;

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
    private MutableLiveData<Address> addressMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<List<ChartData>> stateChartData = new MutableLiveData<>();
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

    public MutableLiveData<Address> getAddress(String url) {
        Call<AddressResult> call = RetrofitInstance.getService().getAddress(url);
        call.enqueue(new Callback<AddressResult>() {
            @Override
            public void onResponse(Call<AddressResult> call, Response<AddressResult> response) {
                AddressResult addressResult = response.body();
                if (addressResult != null && addressResult.getAddresses() != null) {
                    if (!addressResult.getAddresses().isEmpty())
                        addressMutableLiveData.setValue(addressResult.getAddresses().get(0));
                }
            }

            @Override
            public void onFailure(Call<AddressResult> call, Throwable t) {

            }
        });
        return addressMutableLiveData;
    }

    public MutableLiveData<List<ChartData>> getStateChartData(String state) {
        final String stateCode = Util.stateCodes.get(state.toLowerCase());
        if (stateCode != null) {
            Call<StatesDailyResult> call = RetrofitInstance.getService().getDailyChangesState();
            call.enqueue(new Callback<StatesDailyResult>() {
                @Override
                public void onResponse(Call<StatesDailyResult> call, Response<StatesDailyResult> response) {
                    StatesDailyResult statesDailyResult = response.body();
                    if (statesDailyResult != null && statesDailyResult.getStatesDaily() != null) {
                        List<StatesDaily> statesDailyList = statesDailyResult.getStatesDaily();
                        if (!statesDailyList.isEmpty()) {
                            List<ChartData> chartDataList = new ArrayList<>();
                            for (int i = statesDailyList.size() - 3; i >= statesDailyList.size() - 21; i -= 3) {
                                chartDataList.add(new ChartData(Util.formatDateForState(statesDailyList.get(i).getDate()),
                                        Util.getCasesForStateCode(stateCode, statesDailyList.get(i))));
                            }
                            Collections.reverse(chartDataList);
                            stateChartData.setValue(chartDataList);
                        }
                    }
                }

                @Override
                public void onFailure(Call<StatesDailyResult> call, Throwable t) {

                }
            });
        }
        return stateChartData;
    }
}
