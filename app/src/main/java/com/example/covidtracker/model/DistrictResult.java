package com.example.covidtracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DistrictResult implements Parcelable {

    public final static Parcelable.Creator<DistrictResult> CREATOR = new Creator<DistrictResult>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DistrictResult createFromParcel(Parcel in) {
            return new DistrictResult(in);
        }

        public DistrictResult[] newArray(int size) {
            return (new DistrictResult[size]);
        }

    };
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("statecode")
    @Expose
    private String statecode;
    @SerializedName("districtData")
    @Expose
    private List<DistrictWise> districtData = new ArrayList<>();

    public DistrictResult(String state) {
        this.state = state;
    }

    protected DistrictResult(Parcel in) {
        this.state = ((String) in.readValue((String.class.getClassLoader())));
        this.statecode = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.districtData, (DistrictWise.class.getClassLoader()));
    }

    public DistrictResult() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatecode() {
        return statecode;
    }

    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }

    public List<DistrictWise> getDistrictData() {
        return districtData;
    }

    public void setDistrictData(List<DistrictWise> districtData) {
        this.districtData = districtData;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(state);
        dest.writeValue(statecode);
        dest.writeList(districtData);
    }

    public int describeContents() {
        return 0;
    }

}