package com.miskevich.movieholder.dao.jdbc.mapper

import com.miskevich.movieholder.entity.Country
import org.testng.annotations.Test
import static org.testng.Assert.*
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when

import java.sql.ResultSet


class CountryRowMapperTest extends GroovyTestCase {

    private CountryRowMapper countryRowMapper = new CountryRowMapper()

    @Test(dataProvider = "provideCountry", dataProviderClass = DataProviderMapper.class)
    void testMap(Country expectedCountry) {
        ResultSet resultSet = mock(ResultSet.class)
        when(resultSet.next()).thenReturn(true).thenReturn(false)
        when(resultSet.getInt("id")).thenReturn(1)
        when(resultSet.getString("name")).thenReturn("США")

        Country actualCountry = countryRowMapper.map(resultSet)
        assertEquals(actualCountry, expectedCountry)
    }
}
