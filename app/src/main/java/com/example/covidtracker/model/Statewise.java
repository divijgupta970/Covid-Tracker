
package com.example.covidtracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Statewise implements Parcelable {

    public final static Parcelable.Creator<Statewise> CREATOR = new Creator<Statewise>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Statewise createFromParcel(Parcel in) {
            return new Statewise(in);
        }

        public Statewise[] newArray(int size) {
            return (new Statewise[size]);
        }

    };
    @SerializedName("active")
    @Expose
    private String active;
    @SerializedName("confirmed")
    @Expose
    private String confirmed;
    @SerializedName("deaths")
    @Expose
    private String deaths;
    @SerializedName("deltaconfirmed")
    @Expose
    private String deltaconfirmed;
    @SerializedName("deltadeaths")
    @Expose
    private String deltadeaths;
    @SerializedName("deltarecovered")
    @Expose
    private String deltarecovered;
    @SerializedName("lastupdatedtime")
    @Expose
    private String lastupdatedtime;
    @SerializedName("recovered")
    @Expose
    private String recovered;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("statecode")
    @Expose
    private String statecode;
    @SerializedName("statenotes")
    @Expose
    private String statenotes;

    protected Statewise(Parcel in) {
        this.active = ((String) in.readValue((String.class.getClassLoader())));
        this.confirmed = ((String) in.readValue((String.class.getClassLoader())));
        this.deaths = ((String) in.readValue((String.class.getClassLoader())));
        this.deltaconfirmed = ((String) in.readValue((String.class.getClassLoader())));
        this.deltadeaths = ((String) in.readValue((String.class.getClassLoader())));
        this.deltarecovered = ((String) in.readValue((String.class.getClassLoader())));
        this.lastupdatedtime = ((String) in.readValue((String.class.getClassLoader())));
        this.recovered = ((String) in.readValue((String.class.getClassLoader())));
        this.state = ((String) in.readValue((String.class.getClassLoader())));
        this.statecode = ((String) in.readValue((String.class.getClassLoader())));
        this.statenotes = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Statewise() {
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getDeltaconfirmed() {
        return deltaconfirmed;
    }

    public void setDeltaconfirmed(String deltaconfirmed) {
        this.deltaconfirmed = deltaconfirmed;
    }

    public String getDeltadeaths() {
        return deltadeaths;
    }

    public void setDeltadeaths(String deltadeaths) {
        this.deltadeaths = deltadeaths;
    }

    public String getDeltarecovered() {
        return deltarecovered;
    }

    public void setDeltarecovered(String deltarecovered) {
        this.deltarecovered = deltarecovered;
    }

    public String getLastupdatedtime() {
        return lastupdatedtime;
    }

    public void setLastupdatedtime(String lastupdatedtime) {
        this.lastupdatedtime = lastupdatedtime;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
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

    public String getStatenotes() {
        return statenotes;
    }

    public void setStatenotes(String statenotes) {
        this.statenotes = statenotes;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(active);
        dest.writeValue(confirmed);
        dest.writeValue(deaths);
        dest.writeValue(deltaconfirmed);
        dest.writeValue(deltadeaths);
        dest.writeValue(deltarecovered);
        dest.writeValue(lastupdatedtime);
        dest.writeValue(recovered);
        dest.writeValue(state);
        dest.writeValue(statecode);
        dest.writeValue(statenotes);
    }

    public int describeContents() {
        return 0;
    }

}