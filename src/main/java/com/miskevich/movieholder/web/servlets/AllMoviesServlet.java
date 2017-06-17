package com.miskevich.movieholder.web.servlets;

import com.miskevich.movieholder.entity.Movie;
import com.miskevich.movieholder.service.IMovieService;
import com.miskevich.movieholder.service.util.ServiceLocator;
import com.miskevich.movieholder.web.json.JsonConverter;
import com.miskevich.movieholder.web.util.ServletUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AllMoviesServlet extends HttpServlet {
    private IMovieService movieService;

    public AllMoviesServlet() {
        movieService = ServiceLocator.getLocator(IMovieService.class);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        List<Movie> movies;

        Map<String, String[]> parameterMap = request.getParameterMap();

        if(parameterMap.isEmpty()){
            movies = movieService.getAll();
        }else {
            String requestGenreId = ServletUtil.getFirstValueOfRequestParam(request, "genre");
            movies = movieService.getByGenre(Integer.valueOf(requestGenreId));
        }

        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        try (BufferedWriter bufferedWriter = new BufferedWriter(response.getWriter())) {
            bufferedWriter.write(JsonConverter.toJson(movies));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
