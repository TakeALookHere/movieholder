package com.miskevich.movieholder.dao.jdbc

import com.miskevich.movieholder.entity.Movie
import org.apache.commons.dbcp2.BasicDataSource
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test


class JdbcMovieDaoTest extends GroovyTestCase {

    private JdbcMovieDao jdbcMovieDao = new JdbcMovieDao()

    @Test
    void testGetAll() {
        def movies = jdbcMovieDao.getAll()
        for(Movie movie : movies){
            assertNotNull(movie.getId())
            assertNotNull(movie.getNameRussian())
            assertNotNull(movie.getNameNative())
            assertNotNull(movie.getReleasedDate())
            assertNotNull(movie.getPlot())
            assertNotNull(movie.getRating())
            assertNotNull(movie.getPrice())
            assertNotNull(movie.getPicturePath())
        }
    }
}
