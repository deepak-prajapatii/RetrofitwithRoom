package com.riseinsteps.roomtest.roomdbservices;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.riseinsteps.roomtest.Data;

import java.lang.reflect.Type;
import java.util.List;

public class DataConverter {

    @TypeConverter
    public String fromData(List<Data> dataList) {
        if (dataList == null) {
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Data>>() {
        }.getType();
        String json = gson.toJson(dataList, type);
        return json;
    }

    @TypeConverter
    public List<Data> toData(String data) {
        if (data == null) {
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Data>>() {
        }.getType();
        List<Data> dataList = gson.fromJson(data, type);
        return dataList;
    }

}
