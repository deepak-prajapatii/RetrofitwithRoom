package com.riseinsteps.roomtest.retrofitservices;

import com.riseinsteps.roomtest.Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET("api/users?page=1/")
    Call<Model> getModel();

}
