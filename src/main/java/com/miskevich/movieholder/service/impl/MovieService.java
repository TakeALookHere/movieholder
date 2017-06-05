package com.miskevich.movieholder.service.impl;

import com.miskevich.movieholder.dao.IMovieDao;
import com.miskevich.movieholder.dao.jdbc.JdbcMovieDao;
import com.miskevich.movieholder.entity.Movie;
import com.miskevich.movieholder.service.IGenreService;
import com.miskevich.movieholder.service.IMovieService;

import java.util.List;

public class MovieService implements IMovieService {
    private IMovieDao movieDao;
    private IGenreService genreService;

    public MovieService() {
        movieDao = new JdbcMovieDao();
        genreService = new GenreService();
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
