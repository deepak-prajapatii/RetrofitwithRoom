package com.riseinsteps.roomtest.roomdbservices;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.riseinsteps.roomtest.Model;

//@Dao
public interface RoomDao {
//    @Insert
    void insert(Model model);

//    @Query("SELECT * FROM my_table")
    Model getModel();
}
