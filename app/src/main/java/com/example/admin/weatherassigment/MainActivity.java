package com.example.admin.weatherassigment;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.weatherassigment.model.WeatherClass;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "WeatherTAG";
    private EditText etZipCode;
    private TextView txtCountry;
    private TextView txtCity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCity = (TextView) findViewById(R.id.txtCity);
        txtCountry = (TextView) findViewById(R.id.txtCountry);
        etZipCode = (EditText) findViewById(R.id.txtZIPCode);
    }

    public void SearchWeather(View view) {
        String ZipCode = etZipCode.getText().toString();
        if(!ZipCode.isEmpty())
        {
            Call<WeatherClass> getWeather = RetrofitHelper.getWeatherDetails(ZipCode,"bc82aea40a3bad00df74f74a9bd8aa23","imperial");
            getWeather.enqueue(new Callback<WeatherClass>() {
                @Override
                public void onResponse(Call<WeatherClass> call, final Response<WeatherClass> response) {
                    if(response.isSuccessful()) {
                        final WeatherClass weatherClass = response.body();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                txtCity.setText(weatherClass.getCity().getName());
                                txtCountry.setText(weatherClass.getCity().getCountry());
                                ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager1);
                                MyAdapter myAdapter = new MyAdapter(MainActivity.this, weatherClass);
                                viewPager.setAdapter(myAdapter);
                            }
                        });
                    }
                    else
                    {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "Wrong Zip Code", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }

                @Override
                public void onFailure(Call<WeatherClass> call, Throwable t) {
                    Log.d(TAG, "onFailure: "+t.toString());
                }
            });
        }

    }
}
