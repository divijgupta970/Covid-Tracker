package com.example.covidtracker.util;

import com.example.covidtracker.model.DistrictWise;
import com.example.covidtracker.model.Statewise;
import com.example.covidtracker.model.StatisticsData;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

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

    public static final HashMap<String, String> stateCodes = new HashMap<>();
    private static final NavigableMap<Long, String> suffixes = new TreeMap<>();

    static {
        suffixes.put(1_000L, "k");
        suffixes.put(1_000_000L, "M");
    }

    static {
        stateCodes.put("total", "tt");
        stateCodes.put("maharashtra", "mh");
        stateCodes.put("tamilnadu", "tn");
        stateCodes.put("gujarat", "gj");
        stateCodes.put("delhi", "dl");
        stateCodes.put("rajasthan", "rj");
        stateCodes.put("madhya pradesh", "mp");
        stateCodes.put("uttar pradesh", "up");
        stateCodes.put("west bengal", "wb");
        stateCodes.put("andhra pradesh", "ap");
        stateCodes.put("bihar", "br");
        stateCodes.put("karnataka", "ka");
        stateCodes.put("punjab", "pb");
        stateCodes.put("telangana", "tg");
        stateCodes.put("jammu and kashmir", "jk");
        stateCodes.put("odisha", "or");
        stateCodes.put("haryana", "hr");
        stateCodes.put("kerala", "kl");
        stateCodes.put("assam", "as");
        stateCodes.put("jharkhand", "jh");
        stateCodes.put("uttarakhand", "ut");
        stateCodes.put("chattisgarh", "ct");
        stateCodes.put("chandigarh", "ch");
        stateCodes.put("tripura", "tr");
        stateCodes.put("goa", "ga");
        stateCodes.put("ladakh", "la");
        stateCodes.put("puducherry", "py");
        stateCodes.put("manipur", "mn");
        stateCodes.put("andaman and nicobar islands", "an");
        stateCodes.put("meghalaya", "ml");
        stateCodes.put("nagaland", "nl");
        stateCodes.put("dadra and nagar Haveli and daman and diu", "dn");
        stateCodes.put("arunachal pradesh", "ar");
        stateCodes.put("mizoram", "mz");
        stateCodes.put("sikkim", "sk");
        stateCodes.put("lakshadweep", "ld");

    }

    public static String modifyName(String s) {
        StringBuilder sb = new StringBuilder(s);
        int ind = sb.indexOf("&");
        if (ind != -1) {
            sb.deleteCharAt(ind);
            sb.insert(ind, "and");
        }
        int ind2 = sb.indexOf("District");
        if (ind2 != -1) {
            sb.delete(ind2, sb.length());
        }
        return sb.toString().toLowerCase().trim();
    }

    public static String format(long value) {
        if (value == Long.MIN_VALUE) return format(Long.MIN_VALUE + 1);
        if (value < 0) return "-" + format(-value);
        if (value < 1000) return Long.toString(value); //deal with easy case

        Map.Entry<Long, String> e = suffixes.floorEntry(value);
        Long divideBy = e.getKey();
        String suffix = e.getValue();

        long truncated = value / (divideBy / 10); //the number part of the output times 10
        boolean hasDecimal = truncated < 100 && (truncated / 10d) != (truncated / 10);
        return hasDecimal ? (truncated / 10d) + suffix : (truncated / 10) + suffix;
    }

    public static String formatDateForState(String dateStr) {
        try {
            DateFormat srcDf = new SimpleDateFormat("dd-MMM-yy");
            Date date = srcDf.parse(dateStr);
            DateFormat destDf = new SimpleDateFormat("d MMM");
            dateStr = destDf.format(date);
            return dateStr;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String formatDateForDistrict(String dateStr) {
        try {
            DateFormat srcDf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = srcDf.parse(dateStr);
            DateFormat destDf = new SimpleDateFormat("d MMM");
            dateStr = destDf.format(date);
            return dateStr;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getIgnoreCase(JSONObject jobj, String key) {

        Iterator<String> iter = jobj.keys();
        while (iter.hasNext()) {
            String key1 = iter.next();
            if (key1.equalsIgnoreCase(key)) {
                try {
                    return jobj.get(key1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }
}
