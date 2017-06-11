package com.miskevich.movieholder.dao.jdbc;

import com.miskevich.movieholder.dao.IGenreDao;
import com.miskevich.movieholder.dao.jdbc.mapper.GenreRowMapper;
import com.miskevich.movieholder.dao.jdbc.util.ConnectionSource;
import com.miskevich.movieholder.entity.Genre;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcGenreDao implements IGenreDao{


    private static final String GENRE_ALL_SQL = "select id, name from genre";
    private static final String GENRE_BY_MOVIE_ID_SQL = "select id, name from genre where id in(select distinct genre_id from movie_genre where movie_id = ?)";

    private DataSource dataSource;
    private static final GenreRowMapper GENRE_ROW_MAPPER = new GenreRowMapper();

    public JdbcGenreDao() {
        dataSource = ConnectionSource.createConnectionSource();
    }

    @Override
    public List<Genre> getAll() {
        List<Genre> genres = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GENRE_ALL_SQL);
            ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                genres.add(GENRE_ROW_MAPPER.map(resultSet));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return genres;
    }

    @Override
    public List<Genre> getByMovieId(int movieId) {
        List<Genre> genres = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GENRE_BY_MOVIE_ID_SQL)){
            preparedStatement.setInt(1, movieId);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    genres.add(GENRE_ROW_MAPPER.map(resultSet));
                }
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return genres;
    }
}
