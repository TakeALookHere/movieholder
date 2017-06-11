package com.miskevich.movieholder.dao.jdbc.mapper;

import com.miskevich.movieholder.entity.Country;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryRowMapper implements RowMapper<Country>{

    @Override
    public Country map(ResultSet resultSet) throws SQLException {
        Country country = new Country();
        country.setId(resultSet.getInt("id"));
        country.setName(resultSet.getString("name"));
        return country;
    }
}
