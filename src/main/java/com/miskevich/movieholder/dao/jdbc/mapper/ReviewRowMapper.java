package com.miskevich.movieholder.dao.jdbc.mapper;

import com.miskevich.movieholder.entity.Movie;
import com.miskevich.movieholder.entity.Review;
import com.miskevich.movieholder.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewRowMapper implements RowMapper<Review>{

    @Override
    public Review map(ResultSet resultSet) throws SQLException {
        Review review = new Review();
        review.setId(resultSet.getLong("id"));
        review.setDescription(resultSet.getString("description"));
        Movie movie = new Movie();
        movie.setId(resultSet.getInt("movie_id"));
        review.setMovie(movie);
        User user = new User();
        user.setId(resultSet.getInt("user_id"));
        review.setUser(user);
        return review;
    }
}
