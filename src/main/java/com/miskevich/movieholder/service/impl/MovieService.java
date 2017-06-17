package com.miskevich.movieholder.service.impl;

import com.miskevich.movieholder.dao.IMovieDao;
import com.miskevich.movieholder.dao.jdbc.JdbcMovieDao;
import com.miskevich.movieholder.entity.Movie;
import com.miskevich.movieholder.service.ICountryService;
import com.miskevich.movieholder.service.IGenreService;
import com.miskevich.movieholder.service.IMovieService;
import com.miskevich.movieholder.service.IReviewService;

import java.util.List;

public class MovieService implements IMovieService {
    private IMovieDao movieDao;
    private IGenreService genreService;
    private ICountryService countryService;
    private IReviewService reviewService;

    public MovieService(JdbcMovieDao movieDao, GenreService genreService, CountryService countryService, ReviewService reviewService) {
        setMovieDao(movieDao);
        setGenreService(genreService);
        setCountryService(countryService);
        setReviewService(reviewService);
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

    public void setMovieDao(IMovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public void setGenreService(IGenreService genreService) {
        this.genreService = genreService;
    }

    public void setCountryService(ICountryService countryService) {
        this.countryService = countryService;
    }

    public void setReviewService(IReviewService reviewService) {
        this.reviewService = reviewService;
    }

}
