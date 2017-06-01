package com.miskevich.movieholder.web.servlets;

import com.miskevich.movieholder.service.IMovieService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllMoviesServlet extends HttpServlet {
    private IMovieService movieService;

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response){

    }
}
