package com.riseinsteps.roomtest;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Data {

    @PrimaryKey(autoGenerate = true)
    private Integer mainID;
    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;


    public Data(Integer id, String email, String first_name, String last_name, String avatar) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    public Integer getMainID() {
        return mainID;
    }

    public void setMainID(Integer mainID) {
        this.mainID = mainID;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }
}
