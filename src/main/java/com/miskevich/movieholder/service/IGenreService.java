package com.miskevich.movieholder.service;

import com.miskevich.movieholder.entity.Genre;
import com.miskevich.movieholder.entity.Movie;

import java.util.List;

public interface IGenreService {

    List<Genre> getAll();
    List<Genre> getByMovieId(int movieId);
    Movie enrichWithGenre(Movie movie);
}
