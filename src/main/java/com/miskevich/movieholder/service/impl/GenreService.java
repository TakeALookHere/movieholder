package com.miskevich.movieholder.service.impl;

import com.miskevich.movieholder.dao.IGenreDao;
import com.miskevich.movieholder.dao.jdbc.JdbcGenreDao;
import com.miskevich.movieholder.entity.Genre;
import com.miskevich.movieholder.entity.Movie;
import com.miskevich.movieholder.service.IGenreService;

import java.util.List;

public class GenreService implements IGenreService {

    private IGenreDao genreDao;

    public GenreService(JdbcGenreDao jdbcGenreDao) {
        setGenreDao(jdbcGenreDao);
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

    public void setGenreDao(IGenreDao genreDao) {
        this.genreDao = genreDao;
    }
}
