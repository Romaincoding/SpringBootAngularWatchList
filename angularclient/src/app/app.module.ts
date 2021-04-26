import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import { UserService } from './service/user/user.service';
import { HeaderComponent } from './header/header.component';
import { ControlsDbComponent } from './controls-db/controls-db.component';
import { MovieListComponent } from './movie-list/movie-list.component';
import {MovieService} from "./service/movie/movie.service";

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    UserFormComponent,
    HeaderComponent,
    ControlsDbComponent,
    MovieListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [UserService, MovieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
