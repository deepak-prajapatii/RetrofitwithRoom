package com.riseinsteps.roomtest;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Support {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    private String url;
    private String text;

    public Support(String url, String text) {
        this.url = url;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public String getText() {
        return text;
    }
}
