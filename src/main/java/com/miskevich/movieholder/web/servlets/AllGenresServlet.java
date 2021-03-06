package com.miskevich.movieholder.web.servlets;

import com.miskevich.movieholder.entity.Genre;
import com.miskevich.movieholder.service.IGenreService;
import com.miskevich.movieholder.service.util.ServiceLocator;
import com.miskevich.movieholder.web.json.JsonConverter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class AllGenresServlet extends HttpServlet {
    private IGenreService genreService;

    public AllGenresServlet() {
        genreService = ServiceLocator.getLocator(IGenreService.class);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        List<Genre> movies = genreService.getAll();

        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        try (BufferedWriter bufferedWriter = new BufferedWriter(response.getWriter())) {
            bufferedWriter.write(JsonConverter.toJson(movies));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
