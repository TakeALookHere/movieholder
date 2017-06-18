package com.miskevich.movieholder.dao.jdbc;

import com.miskevich.movieholder.dao.IReviewDao;
import com.miskevich.movieholder.dao.jdbc.mapper.ReviewRowMapper;
import com.miskevich.movieholder.dao.jdbc.datasource.ConnectionSource;
import com.miskevich.movieholder.entity.Review;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcReviewDao implements IReviewDao {

    private static final String REVIEW_BY_MOVIE_ID_SQL = "select id, movie_id, user_id, description from review where movie_id = ?";
    private static final String REVIEW_INSERT_SQL = "insert into review (movie_id, user_id, description) values(?, ?, ?)";
    private static final String REVIEW_DELETE_SQL = "delete from review where id = ?";
    private static final String REVIEW_UPDATE_SQL = "update review set user_id = ?, description = ? where id = ?";

    private static final ReviewRowMapper REVIEW_ROW_MAPPER = new ReviewRowMapper();

    private DataSource dataSource;

    public JdbcReviewDao() {
        dataSource = ConnectionSource.createConnectionSource();
    }

    @Override
    public List<Review> getByMovieId(int movieId) {
        List<Review> reviews = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(REVIEW_BY_MOVIE_ID_SQL)) {
            preparedStatement.setInt(1, movieId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    reviews.add(REVIEW_ROW_MAPPER.map(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reviews;
    }

    @Override
    public Review add(Review review) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(REVIEW_INSERT_SQL)) {

            preparedStatement.setInt(1, review.getMovie().getId());
            preparedStatement.setInt(2, review.getUser().getId());
            preparedStatement.setString(3, review.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return review;
    }

    @Override
    public void remove(Review review) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(REVIEW_DELETE_SQL)) {
            preparedStatement.setLong(1, review.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Review edit(Review review) {
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(REVIEW_UPDATE_SQL)){
        //preparedStatement.setInt(1, );
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return review;
    }
}
