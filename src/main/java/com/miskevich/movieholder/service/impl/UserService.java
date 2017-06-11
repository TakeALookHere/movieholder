package com.miskevich.movieholder.service.impl;

import com.miskevich.movieholder.dao.IUserDao;
import com.miskevich.movieholder.dao.jdbc.JdbcUserDao;
import com.miskevich.movieholder.entity.Review;
import com.miskevich.movieholder.entity.User;
import com.miskevich.movieholder.service.IUserService;

public class UserService implements IUserService{

    private IUserDao userDao;

    public UserService() {
        userDao = new JdbcUserDao();
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public Review enrichWithUser(Review review) {
        review.setUser(getById(review.getUser().getId()));
        return review;
    }
}
