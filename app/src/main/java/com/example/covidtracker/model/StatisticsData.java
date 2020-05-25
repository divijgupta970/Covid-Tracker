package com.example.covidtracker.model;

public class StatisticsData {
    private String location;
    private String active;
    private String deaths;
    private String recovered;
    private String confirmed;
    private String change;

    public StatisticsData(String active, String deaths, String recovered, String confirmed, String change, String location) {
        this.active = active;
        this.deaths = deaths;
        this.recovered = recovered;
        this.confirmed = confirmed;
        this.change = change;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

}
