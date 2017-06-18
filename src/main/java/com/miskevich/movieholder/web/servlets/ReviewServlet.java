package com.miskevich.movieholder.web.servlets;

import com.miskevich.movieholder.entity.Review;
import com.miskevich.movieholder.service.IReviewService;
import com.miskevich.movieholder.service.util.ServiceLocator;
import com.miskevich.movieholder.web.json.JsonConverter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ReviewServlet extends HttpServlet {

    private IReviewService reviewService;

    public ReviewServlet() {
        reviewService = ServiceLocator.getLocator(IReviewService.class);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader reader = request.getReader()) {
            Review review = JsonConverter.fromJson(reader, Review.class);
            Review addedReview = reviewService.add(review);

            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);

            try (BufferedWriter bufferedWriter = new BufferedWriter(response.getWriter())) {
                bufferedWriter.write(JsonConverter.toJson(addedReview));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        try (BufferedReader reader = request.getReader()) {
            Review review = JsonConverter.fromJson(reader, Review.class);
            reviewService.remove(review);

            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
