package com.example.WatchListSpring.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;
public class MovieService {

    List<JsonMovie> filmJsonList = null;

    MovieRepository movieRepository;

    public List<JsonMovie> getMovies() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        movieRepository = retrofit.create(MovieRepository.class);
        Call<SearchWrapper> callJson = movieRepository.searchCategory("950de152fd503f197cbf60096e34a7f9", "fr", "popularity.desc", 1);
        callJson.enqueue(new Callback<SearchWrapper>() {


            @Override
            public void onResponse(Call<SearchWrapper> call, Response<SearchWrapper> response) {
                assert response.body() != null;
                filmJsonList = response.body().results;
                for (JsonMovie jsonMovie : filmJsonList) {
                    System.out.println(jsonMovie.toString());
                }

            }

            @Override
            public void onFailure(Call<SearchWrapper> call, Throwable throwable) {
                System.out.println(throwable.getMessage());

            }

        });
        return filmJsonList;
    }

}
