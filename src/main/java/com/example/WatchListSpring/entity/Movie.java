package com.example.WatchListSpring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Movie {
    public int idDb = 1;
    public int idFilm = 1;
    public String filmImage;
    public String titre;
    public String dateSortie;
    public String Genre;
    public String resume;
    public String popularite;
    public boolean isFavorite = false;
    public boolean watchListed = false;

    public Movie(int idDb, int idFilm, String filmImage, String titre, String dateSortie, String genre, String resume, String popularite,boolean isFavorite, boolean watchListed) {
        this.idDb = idDb;
        this.idFilm = idFilm;
        this.filmImage = filmImage;
        this.titre = titre;
        this.dateSortie = dateSortie;
        Genre = genre;
        this.resume = resume;
        this.popularite = popularite;
        this.isFavorite = isFavorite;
        this.watchListed = watchListed;
    }

    public int getIdDb() {
        return idDb;
    }

    public void setIdDb(int idDb) {
        this.idDb = idDb;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getFilmImage() {
        return filmImage;
    }

    public void setFilmImage(String filmImage) {
        this.filmImage = filmImage;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getPopularite() {
        return popularite;
    }

    public void setPopularite(String popularite) {
        this.popularite = popularite;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public boolean isWatchListed() {
        return watchListed;
    }

    public void setWatchListed(boolean watchListed) {
        this.watchListed = watchListed;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "idDb=" + idDb +
                ", idFilm=" + idFilm +
                ", filmImage='" + filmImage + '\'' +
                ", titre='" + titre + '\'' +
                ", dateSortie='" + dateSortie + '\'' +
                ", Genre='" + Genre + '\'' +
                ", resume='" + resume + '\'' +
                ", popularite='" + popularite + '\'' +
                ", isFavorite=" + isFavorite +
                ", watchListed=" + watchListed +
                '}';
    }
}

