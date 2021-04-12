package com.riseinsteps.roomtest.roomdbservices;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.riseinsteps.roomtest.Support;

import java.lang.reflect.Type;

public class SupportObjectConverter {

    @TypeConverter
    public String fromSupport(Support support) {
        if (support == null) {
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Support>() {
        }.getType();
        String json = gson.toJson(support, type);

        return json;
    }

    @TypeConverter
    public Support toSupport(String support) {
        if (support == null) {
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Support>() {
        }.getType();
        Support supportt = gson.fromJson(support, type);

        return supportt;
    }
}
