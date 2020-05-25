package com.example.covidtracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tested implements Parcelable {

    public final static Parcelable.Creator<Tested> CREATOR = new Creator<Tested>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Tested createFromParcel(Parcel in) {
            return new Tested(in);
        }

        public Tested[] newArray(int size) {
            return (new Tested[size]);
        }

    };
    @SerializedName("individualstestedperconfirmedcase")
    @Expose
    private String individualstestedperconfirmedcase;
    @SerializedName("positivecasesfromsamplesreported")
    @Expose
    private String positivecasesfromsamplesreported;
    @SerializedName("samplereportedtoday")
    @Expose
    private String samplereportedtoday;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("testpositivityrate")
    @Expose
    private String testpositivityrate;
    @SerializedName("testsconductedbyprivatelabs")
    @Expose
    private String testsconductedbyprivatelabs;
    @SerializedName("testsperconfirmedcase")
    @Expose
    private String testsperconfirmedcase;
    @SerializedName("testspermillion")
    @Expose
    private String testspermillion;
    @SerializedName("totalindividualstested")
    @Expose
    private String totalindividualstested;
    @SerializedName("totalpositivecases")
    @Expose
    private String totalpositivecases;
    @SerializedName("totalsamplestested")
    @Expose
    private String totalsamplestested;
    @SerializedName("updatetimestamp")
    @Expose
    private String updatetimestamp;

    protected Tested(Parcel in) {
        this.individualstestedperconfirmedcase = ((String) in.readValue((String.class.getClassLoader())));
        this.positivecasesfromsamplesreported = ((String) in.readValue((String.class.getClassLoader())));
        this.samplereportedtoday = ((String) in.readValue((String.class.getClassLoader())));
        this.source = ((String) in.readValue((String.class.getClassLoader())));
        this.testpositivityrate = ((String) in.readValue((String.class.getClassLoader())));
        this.testsconductedbyprivatelabs = ((String) in.readValue((String.class.getClassLoader())));
        this.testsperconfirmedcase = ((String) in.readValue((String.class.getClassLoader())));
        this.testspermillion = ((String) in.readValue((String.class.getClassLoader())));
        this.totalindividualstested = ((String) in.readValue((String.class.getClassLoader())));
        this.totalpositivecases = ((String) in.readValue((String.class.getClassLoader())));
        this.totalsamplestested = ((String) in.readValue((String.class.getClassLoader())));
        this.updatetimestamp = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Tested() {
    }

    public String getIndividualstestedperconfirmedcase() {
        return individualstestedperconfirmedcase;
    }

    public void setIndividualstestedperconfirmedcase(String individualstestedperconfirmedcase) {
        this.individualstestedperconfirmedcase = individualstestedperconfirmedcase;
    }

    public String getPositivecasesfromsamplesreported() {
        return positivecasesfromsamplesreported;
    }

    public void setPositivecasesfromsamplesreported(String positivecasesfromsamplesreported) {
        this.positivecasesfromsamplesreported = positivecasesfromsamplesreported;
    }

    public String getSamplereportedtoday() {
        return samplereportedtoday;
    }

    public void setSamplereportedtoday(String samplereportedtoday) {
        this.samplereportedtoday = samplereportedtoday;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTestpositivityrate() {
        return testpositivityrate;
    }

    public void setTestpositivityrate(String testpositivityrate) {
        this.testpositivityrate = testpositivityrate;
    }

    public String getTestsconductedbyprivatelabs() {
        return testsconductedbyprivatelabs;
    }

    public void setTestsconductedbyprivatelabs(String testsconductedbyprivatelabs) {
        this.testsconductedbyprivatelabs = testsconductedbyprivatelabs;
    }

    public String getTestsperconfirmedcase() {
        return testsperconfirmedcase;
    }

    public void setTestsperconfirmedcase(String testsperconfirmedcase) {
        this.testsperconfirmedcase = testsperconfirmedcase;
    }

    public String getTestspermillion() {
        return testspermillion;
    }

    public void setTestspermillion(String testspermillion) {
        this.testspermillion = testspermillion;
    }

    public String getTotalindividualstested() {
        return totalindividualstested;
    }

    public void setTotalindividualstested(String totalindividualstested) {
        this.totalindividualstested = totalindividualstested;
    }

    public String getTotalpositivecases() {
        return totalpositivecases;
    }

    public void setTotalpositivecases(String totalpositivecases) {
        this.totalpositivecases = totalpositivecases;
    }

    public String getTotalsamplestested() {
        return totalsamplestested;
    }

    public void setTotalsamplestested(String totalsamplestested) {
        this.totalsamplestested = totalsamplestested;
    }

    public String getUpdatetimestamp() {
        return updatetimestamp;
    }

    public void setUpdatetimestamp(String updatetimestamp) {
        this.updatetimestamp = updatetimestamp;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(individualstestedperconfirmedcase);
        dest.writeValue(positivecasesfromsamplesreported);
        dest.writeValue(samplereportedtoday);
        dest.writeValue(source);
        dest.writeValue(testpositivityrate);
        dest.writeValue(testsconductedbyprivatelabs);
        dest.writeValue(testsperconfirmedcase);
        dest.writeValue(testspermillion);
        dest.writeValue(totalindividualstested);
        dest.writeValue(totalpositivecases);
        dest.writeValue(totalsamplestested);
        dest.writeValue(updatetimestamp);
    }

    public int describeContents() {
        return 0;
    }

}