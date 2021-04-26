package com.example.WatchListSpring.entity;

import com.google.gson.annotations.SerializedName;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class JsonMovie  {
    @Id
    @SerializedName("id")
    public  int idFilm;
    @SerializedName("poster_path")
    public  String filmImage;
    @SerializedName("title")
    public String titre;
    @SerializedName("release_date")
    public  String dateSortie;
    @SerializedName("genre_ids")
    public ArrayList<String> Genre;
    @SerializedName("overview")
    public  String resume;
    @SerializedName("popularity")
    public String popularite;

    //--------------------- GETTERS AND SETTERS--------------------------------//

    public int getIdFilm() {
        return idFilm;
    }

    public String getFilmImage() {
        return filmImage;
    }

    public String getTitre() {
        return titre;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public ArrayList<String> getGenre() {
        return Genre;
    }

    public String getResume() {
        return resume;
    }

    public String getPopularite() {
        return popularite;
    }

    @Override
    public String toString() {
        return "JsonMovie{" +
                "idFilm=" + idFilm +
                ", filmImage='" + filmImage + '\'' +
                ", titre='" + titre + '\'' +
                ", dateSortie='" + dateSortie + '\'' +
                ", Genre=" + Genre +
                ", resume='" + resume + '\'' +
                ", popularite='" + popularite + '\'' +
                '}';
    }
}
