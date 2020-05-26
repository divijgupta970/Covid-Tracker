package com.example.covidtracker.ui;

import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.covidtracker.R;
import com.example.covidtracker.databinding.FragmentStatisticsBinding;
import com.example.covidtracker.model.Address;
import com.example.covidtracker.model.ChartData;
import com.example.covidtracker.model.DistrictWise;
import com.example.covidtracker.model.Statewise;
import com.example.covidtracker.model.StatisticsData;
import com.example.covidtracker.util.Constants;
import com.example.covidtracker.util.CustomBarChartRender;
import com.example.covidtracker.util.Util;
import com.example.covidtracker.viewmodel.MainActivityViewModel;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;


public class StatisticsFragment extends Fragment {

    private MainActivityViewModel viewModel;
    private StatisticsData stateData;
    private StatisticsData countryData;
    private StatisticsData districtData;
    private String curr;
    private FragmentStatisticsBinding binding;
    private ProgressBar progressBar, pbChart;
    private BarChart barChart;

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

        progressBar = binding.progressBar;
        pbChart = binding.pbChart;
        barChart = binding.chart;
        formatBarChart();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void getAddressForLocation(Location location) {
        StringBuilder sb = new StringBuilder("https://apis.mapmyindia.com/advancedmaps/v1/nrssvrwrpaz6u5ac9m929v6qgs7edebz/rev_geocode?lat=").append(location.getLatitude()).append("&lng=").append(location.getLongitude());
        viewModel.getAddress(sb.toString(), false).observe(getActivity(), new Observer<Address>() {
            @Override
            public void onChanged(Address address) {
                String state = Util.modifyName(address.getState());
                String district = Util.modifyName(address.getDistrict());
                getStateData(state);
                getDistrictData(state, district);
            }
        });
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

        viewModel.getStateChartData(s, false).observe(getActivity(), new Observer<List<ChartData>>() {
            @Override
            public void onChanged(List<ChartData> chartDataList) {
                setupChart(chartDataList);
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
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void setupChart(List<ChartData> chartDataList) {
        final String[] dates = new String[chartDataList.size()];
        ArrayList<BarEntry> values = new ArrayList<>();
        for (int i = 0; i < chartDataList.size(); i++) {
            dates[i] = chartDataList.get(i).getDate();
            values.add(new BarEntry((float) i, (float) chartDataList.get(i).getValue()));
        }
        BarDataSet dataSet = new BarDataSet(values, "Number of cases");
        dataSet.setColor(Color.parseColor("#FF5959"));
        BarData barData = new BarData(dataSet);
        barData.setDrawValues(false);
        barData.setBarWidth(0.25f);
        ValueFormatter formatter = new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                return dates[(int) value];
            }
        };
        barChart.getXAxis().setValueFormatter(formatter);
        barChart.setData(barData);
        barChart.invalidate();
        barChart.animateY(1000, Easing.EaseOutCirc);
        pbChart.setVisibility(View.INVISIBLE);
    }

    private void formatBarChart() {
        CustomBarChartRender render = new CustomBarChartRender(barChart, barChart.getAnimator(), barChart.getViewPortHandler());
        render.setRadius(20);
        barChart.setRenderer(render);
        barChart.setTouchEnabled(false);
        barChart.setNoDataText("");
        barChart.getLegend().setEnabled(false);
        barChart.getDescription().setEnabled(false);
        XAxis xAxis = barChart.getXAxis();
        YAxis yAxis = barChart.getAxisLeft();
        xAxis.setGranularity(1f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setAxisLineColor(ContextCompat.getColor(getActivity(), R.color.white));
        Typeface face = Typeface.createFromAsset(getActivity().getAssets(), "font/graphikregular.otf");
        xAxis.setTypeface(face);
        yAxis.setTypeface(face);
        xAxis.setTextColor(ContextCompat.getColor(getActivity(), R.color.chartTextColor));
        yAxis.setTextColor(ContextCompat.getColor(getActivity(), R.color.chartTextColor));
        yAxis.setGridColor(ContextCompat.getColor(getActivity(), R.color.chartTextColor));
        yAxis.enableGridDashedLine(10f, 10f, 0f);
        yAxis.setAxisLineColor(ContextCompat.getColor(getActivity(), R.color.white));
        barChart.getAxisRight().setEnabled(false);
    }
}