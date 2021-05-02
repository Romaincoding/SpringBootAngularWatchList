import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {MovieService} from "../service/movie/movie.service";
import {Movie} from "../model/movie";
import {crewMember, CrewMember} from "../model/crewMember";
import {BehaviorSubject} from "rxjs";
import {map} from "rxjs/operators";

@Component({
  selector: 'app-movie-detail',
  templateUrl: './movie-detail.component.html',
  styleUrls: ['./movie-detail.component.css']
})
export class MovieDetailComponent implements OnInit {

  movie: Movie;
  directors;

  //TODO gérer le Json que je reçois via data, je ne sais pas dans quoi le stocker pour le moment, approfondir angular


  constructor(private route: ActivatedRoute, private movieService: MovieService) {
  }

  ngOnInit() {

    const getDirectorsFromFullCast = data =>
      this.movie = new Movie();
    const id = this.route.snapshot.params['id'];

    const getDirectorsFromFullcast = data => {
      const directors = data.crew.filter(member => {
        return member.job === 'Director'
      })
      return directors
    }

    const unsubscribe =  this.movieService.getMovieFullCast(id)
      .pipe(map(getDirectorsFromFullcast))
      .subscribe(
        {
          next: dirs => {
            const directors = dirs
            this.directors = directors[0].name
            },
          error: error => console.error(error),
        },
      );

    this.movieService.findById(id).subscribe(data =>
      this.movie = data);
    console.log(id);

  }
}

