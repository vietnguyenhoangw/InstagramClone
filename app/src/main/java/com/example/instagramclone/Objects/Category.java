
package com.example.instagramclone.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("categoryID")
    @Expose
    private Integer categoryID;
    @SerializedName("categoryName")
    @Expose
    private String categoryName;
    @SerializedName("status")
    @Expose
    private String status;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Category() {
    }

    /**
     * 
     * @param categoryName
     * @param status
     * @param categoryID
     */
    public Category(Integer categoryID, String categoryName, String status) {
        super();
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.status = status;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public Category withCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
        return this;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category withCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Category withStatus(String status) {
        this.status = status;
        return this;
    }

}
