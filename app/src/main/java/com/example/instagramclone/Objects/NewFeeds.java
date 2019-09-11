
package com.example.instagramclone.Objects;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewFeeds {

    @SerializedName("newfeeds")
    @Expose
    private List<NewFeed> newfeeds = null;

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
    public NewFeeds(List<NewFeed> newfeeds) {
        super();
        this.newfeeds = newfeeds;
    }

    public List<NewFeed> getNewfeeds() {
        return newfeeds;
    }

    public void setNewfeeds(List<NewFeed> newfeeds) {
        this.newfeeds = newfeeds;
    }

    public NewFeeds withNewfeeds(List<NewFeed> newfeeds) {
        this.newfeeds = newfeeds;
        return this;
    }

}
