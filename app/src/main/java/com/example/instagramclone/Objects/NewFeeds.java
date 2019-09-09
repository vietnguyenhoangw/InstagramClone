
package com.example.instagramclone.Objects;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewFeeds {

    @SerializedName("newfeeds")
    @Expose
    private List<Newfeed> newfeeds = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NewFeeds() {
    }

    /**
     * 
     * @param newfeeds
     */
    public NewFeeds(List<Newfeed> newfeeds) {
        super();
        this.newfeeds = newfeeds;
    }

    public List<Newfeed> getNewfeeds() {
        return newfeeds;
    }

    public void setNewfeeds(List<Newfeed> newfeeds) {
        this.newfeeds = newfeeds;
    }

    public NewFeeds withNewfeeds(List<Newfeed> newfeeds) {
        this.newfeeds = newfeeds;
        return this;
    }

}
