package com.example.covidtracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictWise implements Parcelable {

    public final static Parcelable.Creator<DistrictWise> CREATOR = new Creator<DistrictWise>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DistrictWise createFromParcel(Parcel in) {
            return new DistrictWise(in);
        }

        public DistrictWise[] newArray(int size) {
            return (new DistrictWise[size]);
        }

    };
    @SerializedName("district")
    @Expose
    private String district;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("active")
    @Expose
    private Integer active;
    @SerializedName("confirmed")
    @Expose
    private Integer confirmed;
    @SerializedName("deceased")
    @Expose
    private Integer deceased;
    @SerializedName("recovered")
    @Expose
    private Integer recovered;
    @SerializedName("delta")
    @Expose
    private DeltaDistrict deltaDistrict;

    public DistrictWise(String district) {
        this.district = district;
    }

    protected DistrictWise(Parcel in) {
        this.district = ((String) in.readValue((String.class.getClassLoader())));
        this.notes = ((String) in.readValue((String.class.getClassLoader())));
        this.active = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.confirmed = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.deceased = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.recovered = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.deltaDistrict = ((DeltaDistrict) in.readValue((DeltaDistrict.class.getClassLoader())));
    }

    public DistrictWise() {
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getDeceased() {
        return deceased;
    }

    public void setDeceased(Integer deceased) {
        this.deceased = deceased;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public DeltaDistrict getDeltaDistrict() {
        return deltaDistrict;
    }

    public void setDeltaDistrict(DeltaDistrict deltaDistrict) {
        this.deltaDistrict = deltaDistrict;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(district);
        dest.writeValue(notes);
        dest.writeValue(active);
        dest.writeValue(confirmed);
        dest.writeValue(deceased);
        dest.writeValue(recovered);
        dest.writeValue(deltaDistrict);
    }

    public int describeContents() {
        return 0;
    }
}


