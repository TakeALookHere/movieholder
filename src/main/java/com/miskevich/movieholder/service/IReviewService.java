package com.miskevich.movieholder.service;

import com.miskevich.movieholder.entity.Movie;
import com.miskevich.movieholder.entity.Review;

import java.util.List;

public interface IReviewService {
    List<Review> getByMovieId(int movieId);
    Movie enrichWithReview(Movie movie);
    Review add(Review review);
}
