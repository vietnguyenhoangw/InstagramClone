
package com.example.instagramclone.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Newfeed {

    @SerializedName("Caption")
    @Expose
    private String caption;
    @SerializedName("Like")
    @Expose
    private String like;
    @SerializedName("PostImage")
    @Expose
    private String postImage;
    @SerializedName("postTime")
    @Expose
    private String postTime;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("userID")
    @Expose
    private Integer userID;
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
    public Newfeed() {
    }

    /**
     * 
     * @param userID
     * @param status
     * @param postImage
     * @param userProfileImage
     * @param userName
     * @param caption
     * @param like
     * @param postTime
     */
    public Newfeed(String caption, String like, String postImage, String postTime, String status, Integer userID, String userName, String userProfileImage) {
        super();
        this.caption = caption;
        this.like = like;
        this.postImage = postImage;
        this.postTime = postTime;
        this.status = status;
        this.userID = userID;
        this.userName = userName;
        this.userProfileImage = userProfileImage;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Newfeed withCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public Newfeed withLike(String like) {
        this.like = like;
        return this;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public Newfeed withPostImage(String postImage) {
        this.postImage = postImage;
        return this;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public Newfeed withPostTime(String postTime) {
        this.postTime = postTime;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Newfeed withStatus(String status) {
        this.status = status;
        return this;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Newfeed withUserID(Integer userID) {
        this.userID = userID;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Newfeed withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserProfileImage() {
        return userProfileImage;
    }

    public void setUserProfileImage(String userProfileImage) {
        this.userProfileImage = userProfileImage;
    }

    public Newfeed withUserProfileImage(String userProfileImage) {
        this.userProfileImage = userProfileImage;
        return this;
    }

}
