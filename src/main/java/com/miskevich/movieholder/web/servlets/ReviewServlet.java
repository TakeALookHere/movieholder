package com.miskevich.movieholder.web.servlets;

import com.miskevich.movieholder.entity.Review;
import com.miskevich.movieholder.service.IReviewService;
import com.miskevich.movieholder.service.util.ServiceLocator;
import com.miskevich.movieholder.web.json.JsonConverter;
import com.miskevich.movieholder.web.util.ServletUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReviewServlet extends HttpServlet {

    private IReviewService reviewService;

    public ReviewServlet() {
        reviewService = ServiceLocator.getLocator(IReviewService.class);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        String json = ServletUtil.generateJson(request);

        Review review = JsonConverter.fromJson(json, Review.class);
        System.out.println(review);

        reviewService.add(review);

        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        try {
            response.sendRedirect("/#/movie?movieId=" + review.getMovie().getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
