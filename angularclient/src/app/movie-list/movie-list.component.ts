import { Component, OnInit } from '@angular/core';
import {Movie} from "../model/movie";
import {MovieService} from "../service/movie/movie.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  movies: Movie[];


  constructor(  private router: Router,
                private movieService : MovieService) { }

  ngOnInit() {
    this.movieService.findAll().subscribe(data => {
      this.movies = data;

    });
  }

  OnViewMovie(movie){

    this.movieService.findById(movie.idFilm).subscribe(data => this.gotoDetailMovie(movie.idFilm));


  }


  gotoDetailMovie(id:number) {
    this.router.navigate([`/movie`, id]);
  }
}
