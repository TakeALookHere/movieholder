package com.miskevich.movieholder.dao;

import com.miskevich.movieholder.entity.Genre;

import java.util.List;

public interface IGenreDao {
    List<Genre> getAll();
    List<Genre> getByMovieId(int movieId);
}
