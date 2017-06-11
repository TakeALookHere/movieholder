package com.miskevich.movieholder.dao.jdbc

import com.miskevich.movieholder.entity.Genre
import org.testng.annotations.Test


class JdbcGenreDaoTest extends GroovyTestCase {
    private JdbcGenreDao jdbcGenreDao = new JdbcGenreDao()

    @Test
    void testGetAll() {
        def genres = jdbcGenreDao.getAll()
        for(Genre genre : genres){
            assertNotNull(genre.getId())
            assertNotNull(genre.getName())
        }
    }

    @Test
    void testGetByMovieId(){
        def genres = jdbcGenreDao.getByMovieId(1)
        for(Genre genre : genres){
            assertNotNull(genre.getId())
            assertNotNull(genre.getName())
        }
    }
}
