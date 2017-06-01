package com.miskevich.movieholder.dao.jdbc.mapper;

import com.miskevich.movieholder.entity.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie>{


    @Override
    public Movie map(ResultSet resultSet) throws SQLException {
        Movie movie = new Movie();
        movie.setId(resultSet.getInt("id"));
        movie.setNameRussian(resultSet.getString("name_russian"));
        movie.setNameNative(resultSet.getString("name_native"));
        movie.setReleasedDate(resultSet.getDate("released_date").toLocalDate());
        movie.setPlot(resultSet.getString("plot"));
        movie.setRating(resultSet.getDouble("rating"));
        movie.setPrice(resultSet.getDouble("price"));
        movie.setPicturePath(resultSet.getString("picture_path"));
        return movie;
    }
}
