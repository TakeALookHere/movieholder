package com.miskevich.movieholder.service.impl;

import com.miskevich.movieholder.dao.IMovieDao;
import com.miskevich.movieholder.entity.Movie;
import com.miskevich.movieholder.service.ICountryService;
import com.miskevich.movieholder.service.IGenreService;
import com.miskevich.movieholder.service.IMovieService;
import com.miskevich.movieholder.service.IReviewService;
import com.miskevich.movieholder.service.util.ServiceLocator;

import java.util.List;

public class MovieService implements IMovieService {
    private IMovieDao movieDao;
    private IGenreService genreService;
    private ICountryService countryService;
    private IReviewService reviewService;

    public MovieService() {
        movieDao = ServiceLocator.getLocator(IMovieDao.class);
        genreService = ServiceLocator.getLocator(IGenreService.class);
        countryService = ServiceLocator.getLocator(ICountryService.class);
        reviewService = ServiceLocator.getLocator(IReviewService.class);
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }

    @Override
    public List<Movie> getByGenre(int id) {
        return movieDao.getByGenre(id);
    }

    @Override
    public Movie getById(int id) {
        Movie movie = movieDao.getById(id);
        genreService.enrichWithGenre(movie);
        countryService.enrichWithCountry(movie);
        reviewService.enrichWithReview(movie);
        return movie;
    }


}
