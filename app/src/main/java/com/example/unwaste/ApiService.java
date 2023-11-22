package com.example.unwaste;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("api/questions/")
    Call<List<Question>> getQuestions();

    @POST("api/questions/")
    Call<Question> createQuestion(@Body Question question);

    @GET("api/restaurants/")
    Call<List<Restaurant>> getRestaurants();

    @POST("api/restaurants/")
    Call<Restaurant> createRestaurant(@Body Restaurant restaurant);
}

