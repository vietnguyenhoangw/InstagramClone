
package com.example.instagramclone.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notification {

    @SerializedName("Content")
    @Expose
    private String content;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("UserName")
    @Expose
    private String userName;
    @SerializedName("userProfileImage")
    @Expose
    private String userProfileImage;

    public Notification(String content, String status, String userName, String userProfileImage) {
        this.content = content;
        this.status = status;
        this.userName = userName;
        this.userProfileImage = userProfileImage;
    }

    public String getUserProfileImage() {
        return userProfileImage;
    }

    public void setUserProfileImage(String userProfileImage) {
        this.userProfileImage = userProfileImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
