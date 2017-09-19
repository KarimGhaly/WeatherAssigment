
package com.example.admin.weatherassigment.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed")
    @Expose
    private Double speed;
    @SerializedName("deg")
    @Expose
    private Double deg;

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Wind withSpeed(Double speed) {
        this.speed = speed;
        return this;
    }

    public Double getDeg() {
        return deg;
    }

    public void setDeg(Double deg) {
        this.deg = deg;
    }

    public Wind withDeg(Double deg) {
        this.deg = deg;
        return this;
    }

}
