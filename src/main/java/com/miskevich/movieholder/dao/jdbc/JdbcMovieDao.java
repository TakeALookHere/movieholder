package com.miskevich.movieholder.dao.jdbc;

import com.miskevich.movieholder.dao.IMovieDao;
import com.miskevich.movieholder.dao.jdbc.mapper.MovieRowMapper;
import com.miskevich.movieholder.entity.Movie;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcMovieDao implements IMovieDao{
    private BasicDataSource dataSource;
    private static final  String MOVIE_ALL_SQL = "select id, name_russian, name_native, released_date, plot, rating, price, picture_path from movie";
    private static final MovieRowMapper MOVIE_ROW_MAPPER = new MovieRowMapper();

    @Override
    public List<Movie> getAll() {
        List<Movie> movies = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(MOVIE_ALL_SQL);
            ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                movies.add(MOVIE_ROW_MAPPER.map(resultSet));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return movies;
    }

    public void setDataSource(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }
}
