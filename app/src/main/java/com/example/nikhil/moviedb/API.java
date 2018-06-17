package com.example.nikhil.moviedb;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by NIKHIL on 16-06-2018.
 */

public interface API {


    //Base url

    String base_url = "https://api.themoviedb.org/3/movie/";

    //Enter end point and method
    @GET("popular?api_key=5c31b55061715e0b80b472a0702966b9")
    //Call<List<Result>> getMovies();

    Call<PopularMovies> getMovies();

}
