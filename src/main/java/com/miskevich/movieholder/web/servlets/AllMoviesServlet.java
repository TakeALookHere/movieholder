package com.miskevich.movieholder.web.servlets;

import com.miskevich.movieholder.entity.Movie;
import com.miskevich.movieholder.service.IMovieService;
import com.miskevich.movieholder.service.impl.MovieService;
import com.miskevich.movieholder.web.json.JsonConverter;
import com.miskevich.movieholder.web.util.ServletUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class AllMoviesServlet extends HttpServlet {
    private IMovieService movieService;

    public AllMoviesServlet() {
        movieService = new MovieService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response){

        List<Movie> movies;

        String requestParam = ServletUtil.getRequestParam(request, "genre");
        if(requestParam.equals("undefined")){
            movies = movieService.getAll();
        }else {
            movies = movieService.getByGenre(Integer.valueOf(requestParam));
        }

        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        try (BufferedWriter bufferedWriter = new BufferedWriter(response.getWriter())){
            bufferedWriter.write(JsonConverter.toJson(movies));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
