import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {MovieService} from "../service/movie/movie.service";
import {Movie} from "../model/movie";

@Component({
  selector: 'app-movie-detail',
  templateUrl: './movie-detail.component.html',
  styleUrls: ['./movie-detail.component.css']
})
export class MovieDetailComponent implements OnInit {

  movie: Movie;

  constructor(private route: ActivatedRoute, private movieService: MovieService) {
  }

  ngOnInit() {
    this.movie = new Movie();
    const id = this.route.snapshot.params['id'];
    this.movieService.findById(id).subscribe(data =>
      this.movie = data);
      console.log(id);
  }

}
