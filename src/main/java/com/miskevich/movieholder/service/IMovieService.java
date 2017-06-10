package com.miskevich.movieholder.service;

import com.miskevich.movieholder.entity.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> getAll();
    List<Movie> getByGenre(int id);
}
