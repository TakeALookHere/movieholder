package com.miskevich.movieholder.dao.jdbc

import com.miskevich.movieholder.entity.Country
import org.testng.annotations.Test


class JdbcCountryDaoTest extends GroovyTestCase {

    private JdbcCountryDao jdbcCountryDao = new JdbcCountryDao()

    @Test
    void testGetByMovieId() {
        def countries = jdbcCountryDao.getByMovieId(6)
        for (Country country : countries){
            assertNotNull(country.getId())
            assertNotNull(country.getName())
        }
    }
}
