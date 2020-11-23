package com.example.testapp.api.models;

import com.google.gson.annotations.SerializedName;

public class Comment {
    @SerializedName("_id")
    private String id;
    @SerializedName("user_id")
    private String userID;
    @SerializedName("user_name")
    private String userName;
    @SerializedName("text")
    private String text;
    @SerializedName("raiting")
    private float raiting;
    @SerializedName("create_at")
    private String createAt;
    @SerializedName("update_at")
    private String updateAt;

    public Comment() {
    }

    public Comment(String id, String userID, String userName, String text, float raiting, String createAt, String updateAt) {
        this.id = id;
        this.userID = userID;
        this.userName = userName;
        this.text = text;
        this.raiting = raiting;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getRaiting() {
        return raiting;
    }

    public void setRaiting(float raiting) {
        this.raiting = raiting;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
}
