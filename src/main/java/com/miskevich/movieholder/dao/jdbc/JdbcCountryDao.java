package com.miskevich.movieholder.dao.jdbc;

import com.miskevich.movieholder.dao.ICountryDao;
import com.miskevich.movieholder.dao.jdbc.mapper.CountryRowMapper;
import com.miskevich.movieholder.dao.jdbc.util.ConnectionSource;
import com.miskevich.movieholder.entity.Country;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcCountryDao implements ICountryDao{

    private static final String COUNTRY_BY_MOVIE_ID_SQL = "select id, name from country where id in(select distinct country_id " +
            "from movie_country where movie_id = ?)";

    private DataSource dataSource;
    private static final CountryRowMapper COUNTRY_ROW_MAPPER = new CountryRowMapper();

    public JdbcCountryDao() {
        dataSource = ConnectionSource.createConnectionSource();
    }

    @Override
    public List<Country> getByMovieId(int movieId) {
        List<Country> countries = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(COUNTRY_BY_MOVIE_ID_SQL)){
            preparedStatement.setInt(1, movieId);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    countries.add(COUNTRY_ROW_MAPPER.map(resultSet));
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return countries;
    }
}
