package com.example.WatchListSpring.controller;

import com.example.WatchListSpring.entity.JsonMovie;
import com.example.WatchListSpring.entity.MovieRepository;
import com.example.WatchListSpring.entity.MovieService;
import com.example.WatchListSpring.entity.SearchWrapper;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {

    List<JsonMovie> filmJsonList = null;

    @GetMapping("/movies")
    public List<JsonMovie> getMovies() throws IOException {
        //TODO gérer le nombre de pages présents dans la réponse etc,


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // on générée l'interface => on dit donc :  tu me generes une implémentation de la class filmDbApi que l'on va stocker dans service
        MovieRepository service = retrofit.create(MovieRepository.class);


        // utilisation d'un des services
        Call<SearchWrapper> callJson = service.searchCategory("950de152fd503f197cbf60096e34a7f9", "fr", "popularity.desc", 1);
        filmJsonList = callJson.execute().body().results;
        return filmJsonList;
    }
}
