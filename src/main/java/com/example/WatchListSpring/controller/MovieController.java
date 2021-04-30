package com.example.WatchListSpring.controller;

import com.example.WatchListSpring.config.MovieDb;
import com.example.WatchListSpring.entity.*;
import org.springframework.web.bind.annotation.*;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {


    List<JsonMovie> filmJsonList = null;
    MovieRepository service;


    @GetMapping("movies/director/{id}")
    public String getCredits(@PathVariable("id") int filmId) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();


        // on générée l'interface => on dit donc :  tu me generes une implémentation de la class filmDbApi que l'on va stocker dans service

        final Call<String> callJson = this.service.findMovieDirector(filmId, MovieDb.API_KEY, MovieDb.LANGUAGE);
        final Response<String> stringResponse = callJson.execute();
        final String body = stringResponse.body();
        return body;


    }
    MovieController() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        // on générée l'interface => on dit donc :  tu me generes une implémentation de la class filmDbApi que l'on va stocker dans service
        this.service = retrofit.create(MovieRepository.class);
    }


    @GetMapping("/movies")
    public List<JsonMovie> getMovies() throws IOException {
        //TODO gérer le nombre de pages présents dans la réponse etc,

        // utilisation d'un des services
        Call<SearchWrapper> callJson = this.service.searchCategory(MovieDb.API_KEY, MovieDb.LANGUAGE, "popularity.desc", 1);
        filmJsonList = callJson.execute().body().results;
        return filmJsonList;
    }

    @GetMapping("movies/{id}")
    public JsonMovie getOneMovie(@PathVariable("id") int filmId) throws IOException {
        System.out.println("je passe bien dans getOneMovie");
        Call<JsonMovie> callJson = this.service.searchOneMovie(filmId, MovieDb.API_KEY, MovieDb.LANGUAGE);
        System.out.println(callJson.request().url());
        final Response<JsonMovie> execute = callJson.execute();
        final JsonMovie body = execute.body();
        System.out.println(body);
        return body;

    }



}
