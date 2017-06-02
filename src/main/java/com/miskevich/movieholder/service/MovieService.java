package com.miskevich.movieholder.service;

import com.miskevich.movieholder.dao.IMovieDao;
import com.miskevich.movieholder.dao.jdbc.JdbcMovieDao;
import com.miskevich.movieholder.entity.Movie;

import java.util.List;

public class MovieService implements IMovieService{
    private IMovieDao movieDao;

    public MovieService() {
        movieDao = new JdbcMovieDao();
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
