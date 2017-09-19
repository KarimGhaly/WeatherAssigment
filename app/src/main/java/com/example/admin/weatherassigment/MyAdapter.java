package com.example.admin.weatherassigment;

import android.content.Context;
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
        TextView itemTxtTemp = (TextView) view.findViewById(R.id.itemTxtTemp);
        TextView itemTxtWind = (TextView) view.findViewById(R.id.itemTxtWind);
        TextView itemTxtHumadity = (TextView) view.findViewById(R.id.itemTxtHumadity);
        ImageView itemIcon = (ImageView) view.findViewById(R.id.itemIcon);
        itemTxtDate.setText(weatherClass.getList().get(position).getDtTxt());
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
