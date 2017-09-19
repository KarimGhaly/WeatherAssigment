package com.example.admin.weatherassigment;

import com.example.admin.weatherassigment.model.Weather;
import com.example.admin.weatherassigment.model.WeatherClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Admin on 9/18/2017.
 */

public class RetrofitHelper {
    public static String BASE_URL = "http://samples.openweathermap.org/data/2.5/";

    public static Retrofit create(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }

    public static Call<WeatherClass> getWeatherDetails(String ZipCode,String AppId)
    {
        Retrofit retrofit = create();
        APIServices apiServices = retrofit.create(APIServices.class);
        return  apiServices.getWeather(ZipCode,AppId);
    }


    interface APIServices{
        @GET ("forecast?zip&APPID")
        Call<WeatherClass>  getWeather(@Query("zip") String ZIPCode, @Query("APPID") String AppID);
    }
}
