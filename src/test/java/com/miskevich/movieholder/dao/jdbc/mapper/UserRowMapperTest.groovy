package com.miskevich.movieholder.dao.jdbc.mapper

import com.miskevich.movieholder.entity.User
import org.testng.annotations.Test

import java.sql.ResultSet

import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when
import static org.testng.Assert.assertEquals

class UserRowMapperTest extends GroovyTestCase {

    private UserRowMapper userRowMapper = new UserRowMapper()

    @Test(dataProvider = "provideUser", dataProviderClass = DataProviderMapper.class)
    void testMap(User expectedUser) {
        ResultSet resultSet = mock(ResultSet.class)
        when(resultSet.next()).thenReturn(true).thenReturn(false)
        when(resultSet.getInt("id")).thenReturn(2)
        when(resultSet.getString("nickname")).thenReturn("Рональд Рейнольдс")
        when(resultSet.getString("email")).thenReturn("ronald.reynolds66@example.com")

        User actualUser = userRowMapper.map(resultSet)
        assertEquals(actualUser, expectedUser)
    }
}
