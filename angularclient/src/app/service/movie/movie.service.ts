import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../../model/user';
import { Observable } from 'rxjs/Observable';
import { Movie } from '../../model/movie';
import {CrewMember} from "../../model/crewMember";

@Injectable()
export class MovieService {

  private movieUrl: string;

  constructor(private http: HttpClient) {
    this.movieUrl = 'http://localhost:9876/movies';
  }

  public findAll(): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.movieUrl);
  }
  public findById(id):  Observable<Movie[]> {
    console.log(`${this.movieUrl}/${id}`);
  return this.http.get<Movie[]>(`${this.movieUrl}/${id}`);
}

  getMovieFullCast(id): Observable<any> {
    return this.http.get<Movie>(`${this.movieUrl}/director/${id}`);

  }
}
