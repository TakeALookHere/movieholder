package com.miskevich.movieholder.service.impl;

import com.miskevich.movieholder.dao.ICountryDao;
import com.miskevich.movieholder.dao.jdbc.JdbcCountryDao;
import com.miskevich.movieholder.entity.Country;
import com.miskevich.movieholder.entity.Movie;
import com.miskevich.movieholder.service.ICountryService;

import java.util.List;

public class CountryService implements ICountryService{

    private ICountryDao countryDao;

    public CountryService() {
        countryDao = new JdbcCountryDao();
    }

    @Override
    public List<Country> getByMovieId(int movieId) {
        return countryDao.getByMovieId(movieId);
    }

    @Override
    public Movie enrichWithCountry(Movie movie) {
        movie.setCountries(getByMovieId(movie.getId()));
        return movie;
    }
}
