package com.example.retrofitt2.network;


import com.example.retrofitt2.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiMovie {
    @GET("/api/users")
    Call<List<Movie>> getMovies();
}
