import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../../model/user';
import { Observable } from 'rxjs/Observable';
import { Movie } from '../../model/movie';

@Injectable()
export class MovieService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8090/movies';
  }

  public findAll(): Observable<Movie[]> {
    console.log("je suis la " + Movie[0]);
    return this.http.get<Movie[]>(this.usersUrl);
  }
}
