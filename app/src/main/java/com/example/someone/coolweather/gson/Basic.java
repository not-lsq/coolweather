package com.example.someone.coolweather.gson;


import com.google.gson.annotations.SerializedName;

/**
 * "basic"中的信息很多，需要的信息为"city","id","update"
 * 使用SerializedName可以将JSON中数据直接传递过来，相当于重命名了。
 * "update"属性对应的值为{}，所以需要定义一个类来解析。也就是每一个{}都要用一个类来解析
 */

public class Basic {

    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    //不用SerializedName的原因是update（变量名）和"update"的名字一样
    public Update update;

    public class Update{

        @SerializedName("loc")
        public String updateTime;
    }
}

