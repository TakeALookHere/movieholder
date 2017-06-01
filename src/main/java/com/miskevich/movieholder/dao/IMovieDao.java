package com.miskevich.movieholder.dao;

import com.miskevich.movieholder.entity.Movie;

import java.util.List;

public interface IMovieDao {
    List<Movie> getAll();
}
