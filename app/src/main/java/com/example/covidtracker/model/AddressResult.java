package com.example.covidtracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AddressResult implements Parcelable {

    public final static Parcelable.Creator<AddressResult> CREATOR = new Creator<AddressResult>() {


        @SuppressWarnings({
                "unchecked"
        })
        public AddressResult createFromParcel(Parcel in) {
            return new AddressResult(in);
        }

        public AddressResult[] newArray(int size) {
            return (new AddressResult[size]);
        }

    };
    @SerializedName("responseCode")
    @Expose
    private Integer responseCode;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("results")
    @Expose
    private List<Address> addresses = new ArrayList<>();

    protected AddressResult(Parcel in) {
        this.responseCode = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.version = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.addresses, (Address.class.getClassLoader()));
    }

    public AddressResult() {
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(responseCode);
        dest.writeValue(version);
        dest.writeList(addresses);
    }

    public int describeContents() {
        return 0;
    }

}