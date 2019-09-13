
package com.example.instagramclone.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Story {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("storyID")
    @Expose
    private Integer storyID;
    @SerializedName("storyImage")
    @Expose
    private Object storyImage;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("userProfileImage")
    @Expose
    private String userProfileImage;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Story() {
    }

    /**
     * 
     * @param storyImage
     * @param status
     * @param storyID
     * @param userProfileImage
     * @param userName
     */
    public Story(String status, Integer storyID, Object storyImage, String userName, String userProfileImage) {
        super();
        this.status = status;
        this.storyID = storyID;
        this.storyImage = storyImage;
        this.userName = userName;
        this.userProfileImage = userProfileImage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Story withStatus(String status) {
        this.status = status;
        return this;
    }

    public Integer getStoryID() {
        return storyID;
    }

    public void setStoryID(Integer storyID) {
        this.storyID = storyID;
    }

    public Story withStoryID(Integer storyID) {
        this.storyID = storyID;
        return this;
    }

    public Object getStoryImage() {
        return storyImage;
    }

    public void setStoryImage(Object storyImage) {
        this.storyImage = storyImage;
    }

    public Story withStoryImage(Object storyImage) {
        this.storyImage = storyImage;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Story withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserProfileImage() {
        return userProfileImage;
    }

    public void setUserProfileImage(String userProfileImage) {
        this.userProfileImage = userProfileImage;
    }

    public Story withUserProfileImage(String userProfileImage) {
        this.userProfileImage = userProfileImage;
        return this;
    }

}
