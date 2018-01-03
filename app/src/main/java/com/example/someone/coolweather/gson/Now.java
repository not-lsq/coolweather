package com.example.someone.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 解析"tmp"和"cond"属性下的信息
 */

public class Now {

    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{

        @SerializedName("txt")
        public String info;
    }
}
