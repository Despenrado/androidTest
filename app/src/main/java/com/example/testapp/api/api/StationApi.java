package com.example.testapp.api.api;


import com.example.testapp.api.models.Station;

import java.util.List;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StationApi {

    @POST("stations")
    public Single<Response<Station>> createStation(@Body Station station);

    @GET("stations/read")
    public Single<Response<List<Station>>> readStations(@Query("skip") int skip, @Query("limit") int limit);

    @GET("stations/{id}")
    public Single<Response<Station>> findById(@Path("id") String id);

    @PUT("stations/{id}")
    public Single<Response<Station>> updateById(@Path("id") String id, @Body Station station);

    @DELETE("stations/{id}")
    public Single<ResponseBody> deleteById(@Path("id") String id);
}
