package com.example.covidtracker.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.covidtracker.R;
import com.example.covidtracker.databinding.FragmentStatisticsBinding;
import com.example.covidtracker.model.DistrictWise;
import com.example.covidtracker.model.Statewise;
import com.example.covidtracker.model.StatisticsData;
import com.example.covidtracker.util.Constants;
import com.example.covidtracker.util.Util;
import com.example.covidtracker.viewmodel.MainActivityViewModel;
import com.google.android.material.chip.ChipGroup;


public class StatisticsFragment extends Fragment {

    private MainActivityViewModel viewModel;
    private StatisticsData stateData;
    private StatisticsData countryData;
    private StatisticsData districtData;
    private String curr;
    private FragmentStatisticsBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stateData = countryData = districtData = Util.getDummyStatsData();
        if (getActivity() != null)
            viewModel = new ViewModelProvider(getActivity()).get(MainActivityViewModel.class);
        curr = Constants.DISTRICT_DATA;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_statistics, container, false);
        View view = binding.getRoot();
        ChipGroup chipGroup = binding.tabsLocation;
        chipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.chipDistrict:
                        binding.setStats(districtData);
                        curr = Constants.DISTRICT_DATA;
                        break;
                    case R.id.chipState:
                        binding.setStats(stateData);
                        curr = Constants.STATE_DATA;
                }
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getStateData("jammu and kashmir");
        getDistrictData("jammu and kashmir", "jammu");
    }

    private void getStateData(String s) {
        viewModel.getStateData(s, false).observe(getActivity(), new Observer<Statewise>() {
            @Override
            public void onChanged(Statewise statewise) {
                stateData = Util.statsFromStateData(statewise);
                if (curr.equals(Constants.STATE_DATA))
                    binding.setStats(stateData);
            }
        });
    }

    private void getDistrictData(String state, String district) {
        viewModel.getDistrictWiseData(state, district, false).observe(getActivity(), new Observer<DistrictWise>() {
            @Override
            public void onChanged(DistrictWise districtWise) {
                districtData = Util.statsFromDistrictData(districtWise);
                if (curr.equals(Constants.DISTRICT_DATA))
                    binding.setStats(districtData);
            }
        });
    }
}