package com.miskevich.movieholder.service;

import com.miskevich.movieholder.dao.IGenreDao;
import com.miskevich.movieholder.dao.jdbc.JdbcGenreDao;
import com.miskevich.movieholder.entity.Genre;

import java.util.List;

public class GenreService implements IGenreService{

    private IGenreDao genreDao;

    public GenreService() {
        genreDao = new JdbcGenreDao();
    }

    @Override
    public List<Genre> getAll() {
        return genreDao.getAll();
    }
}
