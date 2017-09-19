package com.example.admin.weatherassigment;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.admin.weatherassigment.model.WeatherClass;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "WeatherTAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txtCity = (TextView) findViewById(R.id.txtCity);
        final TextView txtCountry = (TextView) findViewById(R.id.txtCountry);


        Call<WeatherClass> getWeather = RetrofitHelper.getWeatherDetails("30067","bc82aea40a3bad00df74f74a9bd8aa23","imperial");


        getWeather.enqueue(new Callback<WeatherClass>() {
            @Override
            public void onResponse(Call<WeatherClass> call, final Response<WeatherClass> response) {
                final WeatherClass weatherClass = response.body();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txtCity.setText(weatherClass.getCity().getName());
                        txtCountry.setText(weatherClass.getCity().getCountry());
                        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager1);
                        MyAdapter myAdapter = new MyAdapter(MainActivity.this,weatherClass);
                        viewPager.setAdapter(myAdapter);
                    }
                });
           }

            @Override
            public void onFailure(Call<WeatherClass> call, Throwable t) {

            }
        });
//
    }
}
