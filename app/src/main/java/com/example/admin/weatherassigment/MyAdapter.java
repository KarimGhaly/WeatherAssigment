package com.example.admin.weatherassigment;

import android.content.Context;
import android.icu.text.DateFormat;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.weatherassigment.model.WeatherClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 9/19/2017.
 */

public class MyAdapter extends PagerAdapter{
    public static final String TAG = "AdapterTAG";
    Context context;
    WeatherClass weatherClass;


    public MyAdapter(Context context, WeatherClass weatherClass) {
        this.context = context;
        this.weatherClass = weatherClass;
    }

    @Override
    public int getCount() {
        return weatherClass.getList().size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout) object) ;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout,container,false);
        TextView itemTxtDate = (TextView) view.findViewById(R.id.itemTxtDate);
        TextView itemTxtHour = (TextView) view.findViewById(R.id.itemTxtHour);
        TextView itemTxtTemp = (TextView) view.findViewById(R.id.itemTxtTemp);
        TextView itemTxtWind = (TextView) view.findViewById(R.id.itemTxtWind);
        TextView itemTxtHumadity = (TextView) view.findViewById(R.id.itemTxtHumadity);
        ImageView itemIcon = (ImageView) view.findViewById(R.id.itemIcon);
        String dateStr ="";
        String timeStr="";
        try {
            Date dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(weatherClass.getList().get(position).getDtTxt());
            SimpleDateFormat Dateoutput = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat Timeoutput = new SimpleDateFormat("HH:mm");
            dateStr = Dateoutput.format(dt);
            timeStr = Timeoutput.format(dt);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        itemTxtDate.setText(dateStr);
        itemTxtHour.setText(timeStr);
        itemTxtTemp.setText("Temp: "+String.valueOf(weatherClass.getList().get(position).getMain().getTemp())+" F");
        itemTxtWind.setText("Wind Speed: "+String.valueOf(weatherClass.getList().get(position).getWind().getSpeed())+" mph");
        itemTxtHumadity.setText("Humidity: "+String.valueOf(weatherClass.getList().get(position).getMain().getHumidity()) + " %");
        String ImageURL = "http://openweathermap.org/img/w/"+weatherClass.getList().get(position).getWeather().get(0).getIcon() +".png";
        Glide.with(context).load(ImageURL).into(itemIcon);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
