package com.example.covidtracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeltaDistrict implements Parcelable {

    public final static Parcelable.Creator<DeltaDistrict> CREATOR = new Creator<DeltaDistrict>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DeltaDistrict createFromParcel(Parcel in) {
            return new DeltaDistrict(in);
        }

        public DeltaDistrict[] newArray(int size) {
            return (new DeltaDistrict[size]);
        }

    };
    @SerializedName("confirmed")
    @Expose
    private Integer confirmed;
    @SerializedName("deceased")
    @Expose
    private Integer deceased;
    @SerializedName("recovered")
    @Expose
    private Integer recovered;

    protected DeltaDistrict(Parcel in) {
        this.confirmed = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.deceased = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.recovered = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public DeltaDistrict() {
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(confirmed);
        dest.writeValue(deceased);
        dest.writeValue(recovered);
    }

    public int describeContents() {
        return 0;
    }

}