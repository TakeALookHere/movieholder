package com.miskevich.movieholder.dao.jdbc

import com.miskevich.movieholder.entity.Review
import org.testng.annotations.Test


class JdbcReviewDaoTest extends GroovyTestCase {

    private JdbcReviewDao jdbcReviewDao = new JdbcReviewDao()

    @Test
    void testGetByMovieId() {
        def reviews = jdbcReviewDao.getByMovieId(24)
        for(Review review : reviews){
            assertNotNull(review.getId())
            assertNotNull(review.getDescription())
            assertNotNull(review.getMovie())
            assertNotNull(review.getUser())
        }
    }
}
