package com.example.WatchListSpring.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface MovieRepository {


//cette interface prépare les request et les réponses

    //URL
// https://api.themoviedb.org/3/search/movie/AVENGERS/?
// api_key=<<api_key>>&language=en-US&
// query=avengers&page=1&include_adult=false
    // Si le paramètre est dans l'URL => c'est un PATH
    // Si le paramètre est après le ? => c'est une QUERY PARAM

    //  https://api.themoviedb.org/3/discover/movie?api_key=d0f80747d8ac43db918936f4a3d09e9c&language=fr&sort_by=popularity.desc&page=1"

   @GET("3/discover/movie?")
    public Call<SearchWrapper> searchCategory(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("sort_by") String tri,
            @Query("page") int page);


    // https://api.themoviedb.org/3/search/movie?api_key=d0f80747d8ac43db918936f4a3d09e9c&language=fr&query=star&page=1&include_adult=false
    @GET("3/movie/{filmId}")
    public Call<JsonMovie> searchOneMovie(
            @Path("filmId") int filmId,
            @Query("api_key") String apiKey,
            @Query("fr") String language);




    //https://api.themoviedb.org/3/discover/movie?api_key=d0f80747d8ac43db918936f4a3d09e9c&language=fr&sort_by=popularity.desc&include_adult=false&page=1&with_genres=28


@GET("3/discover/movie?")
    public Call<SearchWrapper> searchGenre(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("sort_by") String tri,
            @Query("page") int page,
            @Query("with_genres") int genreId);

//     https://api.themoviedb.org/3/discover/movie?api_key=d0f80747d8ac43db918936f4a3d09e9c&language=fr&sort_by=release_date.desc&include_adult=false&include_video=false&page=1&primary_release_date.gte=1920
   @GET("3/discover/movie?")
    public Call<SearchWrapper> searchDate(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("sort_by") String tri,
            @Query("page") int page,
            @Query("primary_release_date.gte") int dateId);

//     REQUETE A L'AFFICHE
//    https://api.themoviedb.org/3/movie/now_playing?api_key=d0f80747d8ac43db918936f4a3d09e9c&language=fr&page=1&region=FR
    @GET("3/movie/now_playing?")
    public Call<SearchWrapper> searchNowPlaying(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page,
            @Query("region") String region);

//    REQUETE BIENTOT A L'AFFICHE
//     https://api.themoviedb.org/3/movie/upcoming?api_key=d0f80747d8ac43db918936f4a3d09e9c&language=fr&page=1&region=FR
    @GET("3/movie/upcoming?")
    public Call<SearchWrapper> findFilmToCome (
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page,
            @Query("region") String region);

}
