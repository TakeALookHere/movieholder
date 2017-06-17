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

    @Test(dataProvider = "provideAddReview", dataProviderClass = DataProviderJdbc.class)
    void testAdd(Review reviewForAdd){
        def review = jdbcReviewDao.add(reviewForAdd)

        assertNotNull(review.getId())
        assertNotNull(review.getMovie().getId())
        assertNotNull(review.getUser().getId())
        assertNotNull(review.getDescription())
    }
}
