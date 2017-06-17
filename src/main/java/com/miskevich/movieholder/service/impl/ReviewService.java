package com.miskevich.movieholder.service.impl;

import com.miskevich.movieholder.dao.IReviewDao;
import com.miskevich.movieholder.dao.jdbc.JdbcReviewDao;
import com.miskevich.movieholder.entity.Movie;
import com.miskevich.movieholder.entity.Review;
import com.miskevich.movieholder.entity.User;
import com.miskevich.movieholder.service.IReviewService;
import com.miskevich.movieholder.service.IUserService;

import java.util.List;

public class ReviewService implements IReviewService {

    private IReviewDao reviewDao;
    private IUserService userService;

    public ReviewService(JdbcReviewDao reviewDao, UserService userService) {
        setReviewDao(reviewDao);
        setUserService(userService);
    }

    @Override
    public List<Review> getByMovieId(int movieId) {
        List<Review> reviews = reviewDao.getByMovieId(movieId);
        for (Review review : reviews) {
            userService.enrichWithUser(review);
        }
        return reviews;
    }

    @Override
    public Movie enrichWithReview(Movie movie) {
        movie.setReviews(getByMovieId(movie.getId()));
        return movie;
    }

    @Override
    public Review add(Review review) {
        User userByNickname = userService.getByNickname(review.getUser().getNickname());
        review.setUser(userByNickname);
        return reviewDao.add(review);
    }

    public void setReviewDao(IReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}
