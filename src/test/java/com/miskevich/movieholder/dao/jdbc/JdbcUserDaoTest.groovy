package com.miskevich.movieholder.dao.jdbc

import org.testng.annotations.Test

class JdbcUserDaoTest extends GroovyTestCase {

    private JdbcUserDao jdbcUserDao = new JdbcUserDao()

    @Test
    void testGetById() {
        def user = jdbcUserDao.getById(2)
        assertNotNull(user.getId())
        assertNotNull(user.getNickname())
        assertNotNull(user.getEmail())
    }

    @Test
    void testGetByNickname(){
        def user = jdbcUserDao.getByNickname('q')
        assertNotNull(user.getId())
        assertNotNull(user.getNickname())
        assertNotNull(user.getEmail())
    }
}
