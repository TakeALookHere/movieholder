package com.miskevich.movieholder.dao;

import com.miskevich.movieholder.entity.Country;

import java.util.List;

public interface ICountryDao {
    List<Country> getByMovieId(int movieId);
}
