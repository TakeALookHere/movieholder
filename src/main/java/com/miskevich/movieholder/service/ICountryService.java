package com.miskevich.movieholder.service;

import com.miskevich.movieholder.entity.Country;
import com.miskevich.movieholder.entity.Movie;

import java.util.List;

public interface ICountryService {
    List<Country> getByMovieId(int movieId);
    Movie enrichWithCountry(Movie movie);
}
