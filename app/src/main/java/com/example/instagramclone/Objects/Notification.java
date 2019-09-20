
package com.example.instagramclone.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notification {

    @SerializedName("Content")
    @Expose
    private Object content;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("UserName")
    @Expose
    private String userName;

    public Object getContent() {
        return content;
    }

    public Notification(Object content, String status, String userName) {
        this.content = content;
        this.status = status;
        this.userName = userName;
    }

    public void setContent(Object content) {
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
