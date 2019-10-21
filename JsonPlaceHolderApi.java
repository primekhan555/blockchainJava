package com.example.blockchain;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {
    @GET("Employee")
    Call<List<GetEmployeeModel>> getValue();

    @GET("Hardware")
    Call<List<GetAssetsModel>> getAssetValue();

    @GET("Allocate")
    Call<List<GetTransModel>> getTransValue();


    @FormUrlEncoded
    @POST("Employee")
    Call<ResponseBody> setEmployeeValues(
            @Field("$class") String $class,
            @Field("employeeId") String employeeId,
            @Field("firstName") String firstName,
            @Field("lastName") String lastName
    );

    @FormUrlEncoded
    @POST("Hardware")
    Call<ResponseBody> setAssetValues(
            @Field("$class") String $class,
            @Field("hardwareId") String hardwareId,
            @Field("name") String name,
            @Field("type") String type,
            @Field("description") String description,
            @Field("quantity") String quantity,
            @Field("owner") String owner
    );

    @FormUrlEncoded
    @POST("Allocate")
    Call<ResponseBody> setTransValues(
            @Field("$class") String $class,
            @Field("hardware") String hardware,
            @Field("newOwner") String newOwner,
            @Field("transactionId") String transactionId,
            @Field("timestamp") String timestamp
    );
}
