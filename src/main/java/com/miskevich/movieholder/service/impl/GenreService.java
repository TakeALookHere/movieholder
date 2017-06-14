package com.miskevich.movieholder.service.impl;

import com.miskevich.movieholder.dao.IGenreDao;
import com.miskevich.movieholder.entity.Genre;
import com.miskevich.movieholder.entity.Movie;
import com.miskevich.movieholder.service.IGenreService;
import com.miskevich.movieholder.service.util.ServiceLocator;

import java.util.List;

public class GenreService implements IGenreService {

    private IGenreDao genreDao;

    public GenreService() {
        genreDao = ServiceLocator.getLocator(IGenreDao.class);
    }

    @Override
    public List<Genre> getAll() {
        return genreDao.getAll();
    }

    @Override
    public List<Genre> getByMovieId(int movieId) {
        return genreDao.getByMovieId(movieId);
    }

    @Override
    public Movie enrichWithGenre(Movie movie) {
        movie.setGenres(getByMovieId(movie.getId()));
        return movie;
    }
}
