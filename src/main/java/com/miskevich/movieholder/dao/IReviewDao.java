package com.miskevich.movieholder.dao;

import com.miskevich.movieholder.entity.Review;

import java.util.List;

public interface IReviewDao {
    List<Review> getByMovieId(int movieId);
    Review add(Review review);
    void remove(Review review);
    Review edit(Review review);
    Review getById(long id);
}
