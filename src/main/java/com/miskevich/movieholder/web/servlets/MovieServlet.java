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

public class MovieServlet extends HttpServlet{

    private IMovieService movieService;

    public MovieServlet() {
        movieService = new MovieService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response){
        String requestMovieId = ServletUtil.getRequestParam(request, "movie");
        Movie movie = movieService.getById(Integer.valueOf(requestMovieId));

        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        try(BufferedWriter bufferedWriter = new BufferedWriter(response.getWriter())){
            bufferedWriter.write(JsonConverter.toJson(movie));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
