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
        User userByNickname;
        User userByNicknameCheck;
        if (null == review.getUser() || (userByNicknameCheck = userService.getByNickname(review.getUser().getNickname())).getId() == 0) {
            userByNickname = userService.getDefaultUser();
        } else {
            userByNickname = userByNicknameCheck;
        }

        review.setUser(userByNickname);
        return reviewDao.add(review);
    }

    @Override
    public void remove(Review review) {
        reviewDao.remove(review);
    }

    @Override
    public Review edit(Review review) {
        return reviewDao.edit(review);
    }

    @Override
    public Review getById(long id) {
        Review review = reviewDao.getById(id);
        return userService.enrichWithUser(review);
    }

    public void setReviewDao(IReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}
