package com.example.testapp.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

public class Station {
    @SerializedName("_id")
    String id;
    @SerializedName("description")
    private String description;
    @SerializedName("station_name")
    private String stationName;
    @SerializedName("position_x")
    private double positionX;
    @SerializedName("position_y")
    private double positionY;
    @SerializedName("update_at")
    private Date updateAt;
    @SerializedName("raiting")
    private float raiting;
    @SerializedName("comments")
    private ArrayList<Comment> comments;

    public Station() {
    }

    public Station(String id, String description, String stationName, double positionX, double positionY, Date updateAt, float raiting, ArrayList<Comment> comments) {
        this.id = id;
        this.description = description;
        this.stationName = stationName;
        this.positionX = positionX;
        this.positionY = positionY;
        this.updateAt = updateAt;
        this.raiting = raiting;
        this.comments = comments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getRaiting() {
        return raiting;
    }

    public void setRaiting(float raiting) {
        this.raiting = raiting;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
