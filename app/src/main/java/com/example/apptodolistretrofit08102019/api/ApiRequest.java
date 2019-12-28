package com.example.apptodolistretrofit08102019.api;

import com.example.apptodolistretrofit08102019.model.Response;
import com.example.apptodolistretrofit08102019.model.Sinhvien;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("sinhvien.php")
    Flowable<Response<List<Sinhvien>>> getListSinhvien();

//    ?appid=86183a23377ed034aef7aad102f43d64&units=metric&q=Hanoi

    @GET("weather")
    Flowable<Response<Object>> getWeather(@Query("appid") String appid,
                                          @Query("units") String units);

    @GET("group/{id}/users")
    Call<List<User>> groupList(@Path("id") int groupId);

    @FormUrlEncoded
    @POST("user/edit")
    Call<User> updateUser(@Field("first_name") String first, @Field("last_name") String last);
}
