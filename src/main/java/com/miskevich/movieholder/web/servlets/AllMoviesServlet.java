package com.miskevich.movieholder.web.servlets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miskevich.movieholder.entity.Movie;
import com.miskevich.movieholder.service.IMovieService;
import com.miskevich.movieholder.service.MovieService;
import com.miskevich.movieholder.web.json.JsonConverter;

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

        List<Movie> movies = movieService.getAll();

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        try (BufferedWriter bufferedWriter = new BufferedWriter(response.getWriter())){
            bufferedWriter.write(JsonConverter.toJson(movies));
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
