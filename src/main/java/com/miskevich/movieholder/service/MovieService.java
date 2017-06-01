package com.miskevich.movieholder.service;

import com.miskevich.movieholder.dao.IMovieDao;
import com.miskevich.movieholder.entity.Movie;

import java.util.List;

public class MovieService implements IMovieService{
    private IMovieDao movieDao;

    @Override
    public List<Movie> getAll() {
        return null;
    }
}
