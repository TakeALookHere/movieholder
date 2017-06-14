package com.miskevich.movieholder.service.impl;

import com.miskevich.movieholder.dao.IReviewDao;
import com.miskevich.movieholder.entity.Movie;
import com.miskevich.movieholder.entity.Review;
import com.miskevich.movieholder.service.IReviewService;
import com.miskevich.movieholder.service.IUserService;
import com.miskevich.movieholder.service.util.ServiceLocator;

import java.util.List;

public class ReviewService implements IReviewService {

    private IReviewDao reviewDao;
    private IUserService userService;

    public ReviewService() {
        reviewDao = ServiceLocator.getLocator(IReviewDao.class);
        userService = ServiceLocator.getLocator(IUserService.class);
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
}
