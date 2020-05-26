package com.example.covidtracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address implements Parcelable {

    public final static Parcelable.Creator<Address> CREATOR = new Creator<Address>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Address createFromParcel(Parcel in) {
            return new Address(in);
        }

        public Address[] newArray(int size) {
            return (new Address[size]);
        }

    };
    @SerializedName("houseNumber")
    @Expose
    private String houseNumber;
    @SerializedName("houseName")
    @Expose
    private String houseName;
    @SerializedName("poi")
    @Expose
    private String poi;
    @SerializedName("poi_dist")
    @Expose
    private String poiDist;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("street_dist")
    @Expose
    private String streetDist;
    @SerializedName("subSubLocality")
    @Expose
    private String subSubLocality;
    @SerializedName("subLocality")
    @Expose
    private String subLocality;
    @SerializedName("locality")
    @Expose
    private String locality;
    @SerializedName("village")
    @Expose
    private String village;
    @SerializedName("district")
    @Expose
    private String district;
    @SerializedName("subDistrict")
    @Expose
    private String subDistrict;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("pincode")
    @Expose
    private String pincode;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lng")
    @Expose
    private String lng;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("formatted_address")
    @Expose
    private String formattedAddress;

    protected Address(Parcel in) {
        this.houseNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.houseName = ((String) in.readValue((String.class.getClassLoader())));
        this.poi = ((String) in.readValue((String.class.getClassLoader())));
        this.poiDist = ((String) in.readValue((String.class.getClassLoader())));
        this.street = ((String) in.readValue((String.class.getClassLoader())));
        this.streetDist = ((String) in.readValue((String.class.getClassLoader())));
        this.subSubLocality = ((String) in.readValue((String.class.getClassLoader())));
        this.subLocality = ((String) in.readValue((String.class.getClassLoader())));
        this.locality = ((String) in.readValue((String.class.getClassLoader())));
        this.village = ((String) in.readValue((String.class.getClassLoader())));
        this.district = ((String) in.readValue((String.class.getClassLoader())));
        this.subDistrict = ((String) in.readValue((String.class.getClassLoader())));
        this.city = ((String) in.readValue((String.class.getClassLoader())));
        this.state = ((String) in.readValue((String.class.getClassLoader())));
        this.pincode = ((String) in.readValue((String.class.getClassLoader())));
        this.lat = ((String) in.readValue((String.class.getClassLoader())));
        this.lng = ((String) in.readValue((String.class.getClassLoader())));
        this.area = ((String) in.readValue((String.class.getClassLoader())));
        this.formattedAddress = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Address() {
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getPoi() {
        return poi;
    }

    public void setPoi(String poi) {
        this.poi = poi;
    }

    public String getPoiDist() {
        return poiDist;
    }

    public void setPoiDist(String poiDist) {
        this.poiDist = poiDist;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetDist() {
        return streetDist;
    }

    public void setStreetDist(String streetDist) {
        this.streetDist = streetDist;
    }

    public String getSubSubLocality() {
        return subSubLocality;
    }

    public void setSubSubLocality(String subSubLocality) {
        this.subSubLocality = subSubLocality;
    }

    public String getSubLocality() {
        return subLocality;
    }

    public void setSubLocality(String subLocality) {
        this.subLocality = subLocality;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(houseNumber);
        dest.writeValue(houseName);
        dest.writeValue(poi);
        dest.writeValue(poiDist);
        dest.writeValue(street);
        dest.writeValue(streetDist);
        dest.writeValue(subSubLocality);
        dest.writeValue(subLocality);
        dest.writeValue(locality);
        dest.writeValue(village);
        dest.writeValue(district);
        dest.writeValue(subDistrict);
        dest.writeValue(city);
        dest.writeValue(state);
        dest.writeValue(pincode);
        dest.writeValue(lat);
        dest.writeValue(lng);
        dest.writeValue(area);
        dest.writeValue(formattedAddress);
    }

    public int describeContents() {
        return 0;
    }

}