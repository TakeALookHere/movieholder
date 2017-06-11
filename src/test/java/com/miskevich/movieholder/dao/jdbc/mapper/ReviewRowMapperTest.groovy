package com.miskevich.movieholder.dao.jdbc.mapper

import com.miskevich.movieholder.entity.Review
import org.testng.annotations.Test
import static org.testng.Assert.*
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when

import java.sql.ResultSet


class ReviewRowMapperTest extends GroovyTestCase {

    private ReviewRowMapper reviewRowMapper = new ReviewRowMapper()

    @Test(dataProvider = "provideReview", dataProviderClass = DataProviderMapper.class)
    void testMap(Review expectedReview) {
        ResultSet resultSet = mock(ResultSet.class)
        when(resultSet.next()).thenReturn(true).thenReturn(false)
        when(resultSet.getLong("id")).thenReturn(1l)
        when(resultSet.getString("description")).thenReturn("Гениальное кино! Смотришь и думаешь «Так не бывает!», но позже понимаешь, что только так и должно быть. Начинаешь заново осмысливать значение фразы, которую постоянно используешь в своей жизни, «Надежда умирает последней». Ведь если ты не надеешься, то все в твоей жизни гаснет, не остается смысла. Фильм наполнен бесконечным числом правильных афоризмов. Я уверена, что буду пересматривать его сотни раз.")
        when(resultSet.getInt("movie_id")).thenReturn(1)
        when(resultSet.getInt("user_id")).thenReturn(3)

        def actualReview = reviewRowMapper.map(resultSet)
        assertEquals(actualReview, expectedReview)
    }
}
