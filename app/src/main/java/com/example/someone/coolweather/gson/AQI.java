package com.example.someone.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 只解析"city"类别下的信息
 */

public class AQI {

    public AQICity city;

    public class AQICity{

        public String aqi;

        public String pm25;
    }
}
