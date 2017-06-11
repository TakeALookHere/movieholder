package com.miskevich.movieholder.dao.jdbc;

import com.miskevich.movieholder.dao.IReviewDao;
import com.miskevich.movieholder.dao.jdbc.mapper.ReviewRowMapper;
import com.miskevich.movieholder.dao.jdbc.util.ConnectionSource;
import com.miskevich.movieholder.entity.Review;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcReviewDao implements IReviewDao{

    private static final String REVIEW_BY_MOVIE_ID_SQL = "select id, movie_id, user_id, description from review where movie_id = ?";

    private DataSource dataSource;
    private static final ReviewRowMapper REVIEW_ROW_MAPPER = new ReviewRowMapper();

    public JdbcReviewDao() {
        dataSource = ConnectionSource.createConnectionSource();
    }

    @Override
    public List<Review> getByMovieId(int movieId) {
        List<Review> reviews = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(REVIEW_BY_MOVIE_ID_SQL)){
            preparedStatement.setInt(1, movieId);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    reviews.add(REVIEW_ROW_MAPPER.map(resultSet));
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return reviews;
    }
}
