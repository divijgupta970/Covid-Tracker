package com.example.covidtracker.util;

import com.example.covidtracker.model.DistrictWise;
import com.example.covidtracker.model.Statewise;
import com.example.covidtracker.model.StatisticsData;

public class Util {
    public static StatisticsData statsFromDistrictData(DistrictWise districtWise) {
        return new StatisticsData(districtWise.getActive().toString(), districtWise.getDeceased().toString(), districtWise.getRecovered().toString(), districtWise.getConfirmed().toString(), districtWise.getDeltaDistrict().getConfirmed().toString(), districtWise.getDistrict());
    }

    public static StatisticsData statsFromStateData(Statewise statewise) {
        return new StatisticsData(statewise.getActive(), statewise.getDeaths(), statewise.getRecovered(), statewise.getConfirmed(), statewise.getDeltaconfirmed(), statewise.getState());
    }

    public static StatisticsData getDummyStatsData() {
        return new StatisticsData("", "", "", "", "", "");
    }
}
