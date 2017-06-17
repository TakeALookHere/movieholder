package com.miskevich.movieholder.service.util;

import com.miskevich.movieholder.dao.*;
import com.miskevich.movieholder.dao.jdbc.*;
import com.miskevich.movieholder.service.*;
import com.miskevich.movieholder.service.impl.*;

import java.util.HashMap;
import java.util.Map;

public class ServiceLocator {

    private static final Map<Class<?>, Object> LOCATOR = new HashMap<>();

    static {
        JdbcCountryDao countryDao = new JdbcCountryDao();
        CountryService countryService = new CountryService(countryDao);
        LOCATOR.put(ICountryService.class, countryService);

        JdbcGenreDao jdbcGenreDao = new JdbcGenreDao();
        GenreService genreService = new GenreService(jdbcGenreDao);
        LOCATOR.put(IGenreService.class, genreService);

        JdbcUserDao jdbcUserDao = new JdbcUserDao();
        UserService userService = new UserService(jdbcUserDao);
        LOCATOR.put(IUserService.class, userService);

        JdbcReviewDao reviewDao = new JdbcReviewDao();
        ReviewService reviewService = new ReviewService(reviewDao, userService);
        LOCATOR.put(IReviewService.class, reviewService);


        JdbcMovieDao movieDao = new JdbcMovieDao();
        MovieService movieService = new MovieService(movieDao, genreService, countryService, reviewService);
        LOCATOR.put(IMovieService.class, movieService);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getLocator(Class<?> value) {
        return (T) LOCATOR.get(value);
    }
}
