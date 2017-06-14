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
        LOCATOR.put(ICountryDao.class, new JdbcCountryDao());
        LOCATOR.put(ICountryService.class, new CountryService());

        LOCATOR.put(IGenreDao.class, new JdbcGenreDao());
        LOCATOR.put(IGenreService.class, new GenreService());

        LOCATOR.put(IReviewDao.class, new JdbcReviewDao());
        LOCATOR.put(IReviewService.class, new ReviewService());

        LOCATOR.put(IUserDao.class, new JdbcUserDao());
        LOCATOR.put(IUserService.class, new UserService());

        LOCATOR.put(IMovieDao.class, new JdbcMovieDao());
        LOCATOR.put(IMovieService.class, new MovieService());
    }

    @SuppressWarnings("unchecked")
    public static <T> T getLocator(Class<?> value) {
        return (T) LOCATOR.get(value);
    }
}
