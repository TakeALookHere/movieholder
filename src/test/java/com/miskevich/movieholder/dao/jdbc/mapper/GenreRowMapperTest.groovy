package com.miskevich.movieholder.dao.jdbc.mapper

import com.miskevich.movieholder.entity.Genre
import org.testng.annotations.Test
import static org.testng.Assert.*
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when
import java.sql.ResultSet


class GenreRowMapperTest extends GroovyTestCase {

    private GenreRowMapper genreRowMapper = new GenreRowMapper()

    @Test(dataProvider = "provideGenre", dataProviderClass = DataProviderMapper.class)
    void testMap(Genre expectedGenre) {
        ResultSet resultSet = mock(ResultSet.class)
        when(resultSet.next()).thenReturn(true).thenReturn(false)
        when(resultSet.getInt("id")).thenReturn(1)
        when(resultSet.getString("name")).thenReturn("драма")

        Genre actualGenre = genreRowMapper.map(resultSet)
        assertEquals(actualGenre, expectedGenre)
    }
}
