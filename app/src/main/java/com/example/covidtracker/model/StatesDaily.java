package com.example.covidtracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatesDaily implements Parcelable {

    public final static Parcelable.Creator<StatesDaily> CREATOR = new Creator<StatesDaily>() {


        @SuppressWarnings({
                "unchecked"
        })
        public StatesDaily createFromParcel(Parcel in) {
            return new StatesDaily(in);
        }

        public StatesDaily[] newArray(int size) {
            return (new StatesDaily[size]);
        }

    };
    @SerializedName("an")
    @Expose
    private String an;
    @SerializedName("ap")
    @Expose
    private String ap;
    @SerializedName("ar")
    @Expose
    private String ar;
    @SerializedName("as")
    @Expose
    private String as;
    @SerializedName("br")
    @Expose
    private String br;
    @SerializedName("ch")
    @Expose
    private String ch;
    @SerializedName("ct")
    @Expose
    private String ct;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("dd")
    @Expose
    private String dd;
    @SerializedName("dl")
    @Expose
    private String dl;
    @SerializedName("dn")
    @Expose
    private String dn;
    @SerializedName("ga")
    @Expose
    private String ga;
    @SerializedName("gj")
    @Expose
    private String gj;
    @SerializedName("hp")
    @Expose
    private String hp;
    @SerializedName("hr")
    @Expose
    private String hr;
    @SerializedName("jh")
    @Expose
    private String jh;
    @SerializedName("jk")
    @Expose
    private String jk;
    @SerializedName("ka")
    @Expose
    private String ka;
    @SerializedName("kl")
    @Expose
    private String kl;
    @SerializedName("la")
    @Expose
    private String la;
    @SerializedName("ld")
    @Expose
    private String ld;
    @SerializedName("mh")
    @Expose
    private String mh;
    @SerializedName("ml")
    @Expose
    private String ml;
    @SerializedName("mn")
    @Expose
    private String mn;
    @SerializedName("mp")
    @Expose
    private String mp;
    @SerializedName("mz")
    @Expose
    private String mz;
    @SerializedName("nl")
    @Expose
    private String nl;
    @SerializedName("or")
    @Expose
    private String or;
    @SerializedName("pb")
    @Expose
    private String pb;
    @SerializedName("py")
    @Expose
    private String py;
    @SerializedName("rj")
    @Expose
    private String rj;
    @SerializedName("sk")
    @Expose
    private String sk;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tg")
    @Expose
    private String tg;
    @SerializedName("tn")
    @Expose
    private String tn;
    @SerializedName("tr")
    @Expose
    private String tr;
    @SerializedName("tt")
    @Expose
    private String tt;
    @SerializedName("un")
    @Expose
    private String un;
    @SerializedName("up")
    @Expose
    private String up;
    @SerializedName("ut")
    @Expose
    private String ut;
    @SerializedName("wb")
    @Expose
    private String wb;

    protected StatesDaily(Parcel in) {
        this.an = ((String) in.readValue((String.class.getClassLoader())));
        this.ap = ((String) in.readValue((String.class.getClassLoader())));
        this.ar = ((String) in.readValue((String.class.getClassLoader())));
        this.as = ((String) in.readValue((String.class.getClassLoader())));
        this.br = ((String) in.readValue((String.class.getClassLoader())));
        this.ch = ((String) in.readValue((String.class.getClassLoader())));
        this.ct = ((String) in.readValue((String.class.getClassLoader())));
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.dd = ((String) in.readValue((String.class.getClassLoader())));
        this.dl = ((String) in.readValue((String.class.getClassLoader())));
        this.dn = ((String) in.readValue((String.class.getClassLoader())));
        this.ga = ((String) in.readValue((String.class.getClassLoader())));
        this.gj = ((String) in.readValue((String.class.getClassLoader())));
        this.hp = ((String) in.readValue((String.class.getClassLoader())));
        this.hr = ((String) in.readValue((String.class.getClassLoader())));
        this.jh = ((String) in.readValue((String.class.getClassLoader())));
        this.jk = ((String) in.readValue((String.class.getClassLoader())));
        this.ka = ((String) in.readValue((String.class.getClassLoader())));
        this.kl = ((String) in.readValue((String.class.getClassLoader())));
        this.la = ((String) in.readValue((String.class.getClassLoader())));
        this.ld = ((String) in.readValue((String.class.getClassLoader())));
        this.mh = ((String) in.readValue((String.class.getClassLoader())));
        this.ml = ((String) in.readValue((String.class.getClassLoader())));
        this.mn = ((String) in.readValue((String.class.getClassLoader())));
        this.mp = ((String) in.readValue((String.class.getClassLoader())));
        this.mz = ((String) in.readValue((String.class.getClassLoader())));
        this.nl = ((String) in.readValue((String.class.getClassLoader())));
        this.or = ((String) in.readValue((String.class.getClassLoader())));
        this.pb = ((String) in.readValue((String.class.getClassLoader())));
        this.py = ((String) in.readValue((String.class.getClassLoader())));
        this.rj = ((String) in.readValue((String.class.getClassLoader())));
        this.sk = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.tg = ((String) in.readValue((String.class.getClassLoader())));
        this.tn = ((String) in.readValue((String.class.getClassLoader())));
        this.tr = ((String) in.readValue((String.class.getClassLoader())));
        this.tt = ((String) in.readValue((String.class.getClassLoader())));
        this.un = ((String) in.readValue((String.class.getClassLoader())));
        this.up = ((String) in.readValue((String.class.getClassLoader())));
        this.ut = ((String) in.readValue((String.class.getClassLoader())));
        this.wb = ((String) in.readValue((String.class.getClassLoader())));
    }

    public StatesDaily() {
    }

    public String getAn() {
        return an;
    }

    public void setAn(String an) {
        this.an = an;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
    }

    public String getAs() {
        return as;
    }

    public void setAs(String as) {
        this.as = as;
    }

    public String getBr() {
        return br;
    }

    public void setBr(String br) {
        this.br = br;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }

    public String getDl() {
        return dl;
    }

    public void setDl(String dl) {
        this.dl = dl;
    }

    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    public String getGa() {
        return ga;
    }

    public void setGa(String ga) {
        this.ga = ga;
    }

    public String getGj() {
        return gj;
    }

    public void setGj(String gj) {
        this.gj = gj;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

    public String getJh() {
        return jh;
    }

    public void setJh(String jh) {
        this.jh = jh;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getKa() {
        return ka;
    }

    public void setKa(String ka) {
        this.ka = ka;
    }

    public String getKl() {
        return kl;
    }

    public void setKl(String kl) {
        this.kl = kl;
    }

    public String getLa() {
        return la;
    }

    public void setLa(String la) {
        this.la = la;
    }

    public String getLd() {
        return ld;
    }

    public void setLd(String ld) {
        this.ld = ld;
    }

    public String getMh() {
        return mh;
    }

    public void setMh(String mh) {
        this.mh = mh;
    }

    public String getMl() {
        return ml;
    }

    public void setMl(String ml) {
        this.ml = ml;
    }

    public String getMn() {
        return mn;
    }

    public void setMn(String mn) {
        this.mn = mn;
    }

    public String getMp() {
        return mp;
    }

    public void setMp(String mp) {
        this.mp = mp;
    }

    public String getMz() {
        return mz;
    }

    public void setMz(String mz) {
        this.mz = mz;
    }

    public String getNl() {
        return nl;
    }

    public void setNl(String nl) {
        this.nl = nl;
    }

    public String getOr() {
        return or;
    }

    public void setOr(String or) {
        this.or = or;
    }

    public String getPb() {
        return pb;
    }

    public void setPb(String pb) {
        this.pb = pb;
    }

    public String getPy() {
        return py;
    }

    public void setPy(String py) {
        this.py = py;
    }

    public String getRj() {
        return rj;
    }

    public void setRj(String rj) {
        this.rj = rj;
    }

    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTg() {
        return tg;
    }

    public void setTg(String tg) {
        this.tg = tg;
    }

    public String getTn() {
        return tn;
    }

    public void setTn(String tn) {
        this.tn = tn;
    }

    public String getTr() {
        return tr;
    }

    public void setTr(String tr) {
        this.tr = tr;
    }

    public String getTt() {
        return tt;
    }

    public void setTt(String tt) {
        this.tt = tt;
    }

    public String getUn() {
        return un;
    }

    public void setUn(String un) {
        this.un = un;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getUt() {
        return ut;
    }

    public void setUt(String ut) {
        this.ut = ut;
    }

    public String getWb() {
        return wb;
    }

    public void setWb(String wb) {
        this.wb = wb;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(an);
        dest.writeValue(ap);
        dest.writeValue(ar);
        dest.writeValue(as);
        dest.writeValue(br);
        dest.writeValue(ch);
        dest.writeValue(ct);
        dest.writeValue(date);
        dest.writeValue(dd);
        dest.writeValue(dl);
        dest.writeValue(dn);
        dest.writeValue(ga);
        dest.writeValue(gj);
        dest.writeValue(hp);
        dest.writeValue(hr);
        dest.writeValue(jh);
        dest.writeValue(jk);
        dest.writeValue(ka);
        dest.writeValue(kl);
        dest.writeValue(la);
        dest.writeValue(ld);
        dest.writeValue(mh);
        dest.writeValue(ml);
        dest.writeValue(mn);
        dest.writeValue(mp);
        dest.writeValue(mz);
        dest.writeValue(nl);
        dest.writeValue(or);
        dest.writeValue(pb);
        dest.writeValue(py);
        dest.writeValue(rj);
        dest.writeValue(sk);
        dest.writeValue(status);
        dest.writeValue(tg);
        dest.writeValue(tn);
        dest.writeValue(tr);
        dest.writeValue(tt);
        dest.writeValue(un);
        dest.writeValue(up);
        dest.writeValue(ut);
        dest.writeValue(wb);
    }

    public int describeContents() {
        return 0;
    }

}
