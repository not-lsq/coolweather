package com.example.someone.coolweather.util;

import android.text.TextUtils;

import com.example.someone.coolweather.db.City;
import com.example.someone.coolweather.db.County;
import com.example.someone.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by someone on 2017/12/21.
 */

public class Utility {

    /**
     * 解析和处理服务器返回的数据
     */
    public static boolean handleProvinceResponse(String response) {
        //通过TextUtils工具类的静态方法，判断字符串是否为null或者为“”
        if (!TextUtils.isEmpty(response)) {
            try {
                //通过JSONArray的有参构造函数，创建JSONArray
                JSONArray allProvinces = new JSONArray(response);
                for (int i=0;i<allProvinces.length();i++) {
                    //类似数组的操作，通过getJSONObject(i)获取指定索引下的JSON对象
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    //JSON对象通过getString()和getInt()获取包含的内容
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i=0;i<allCities.length();i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountyResponse(String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCounties = new JSONArray(response);
                for (int i = 0; i < allCounties.length(); i++) {
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
