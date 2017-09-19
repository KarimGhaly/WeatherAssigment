
package com.example.admin.weatherassigment.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherClass {

    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private Double message;
    @SerializedName("cnt")
    @Expose
    private Integer cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<com.example.admin.weatherassigment.model.List> list = null;
    @SerializedName("city")
    @Expose
    private City city;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public WeatherClass withCod(String cod) {
        this.cod = cod;
        return this;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public WeatherClass withMessage(Double message) {
        this.message = message;
        return this;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public WeatherClass withCnt(Integer cnt) {
        this.cnt = cnt;
        return this;
    }

    public java.util.List<com.example.admin.weatherassigment.model.List> getList() {
        return list;
    }

    public void setList(java.util.List<com.example.admin.weatherassigment.model.List> list) {
        this.list = list;
    }

    public WeatherClass withList(java.util.List<com.example.admin.weatherassigment.model.List> list) {
        this.list = list;
        return this;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public WeatherClass withCity(City city) {
        this.city = city;
        return this;
    }

}
