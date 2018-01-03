package com.example.someone.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * daily_forecast中的数据是[],这里定义了单日天气的实体类
 */

public class Forecast {

    public String date;

    @SerializedName("tmp")
    public Temperature temperature;

    @SerializedName("cond")
    public More more;

    public class Temperature{
        public String max;
        public String min;
    }

    public class More{
        @SerializedName("txt_d")
        public String info;
    }
}
