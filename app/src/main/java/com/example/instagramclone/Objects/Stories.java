
package com.example.instagramclone.Objects;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stories {

    @SerializedName("stories")
    @Expose
    private List<Story> stories = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Stories() {
    }

    /**
     * 
     * @param stories
     */
    public Stories(List<Story> stories) {
        super();
        this.stories = stories;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public Stories withStories(List<Story> stories) {
        this.stories = stories;
        return this;
    }

}
