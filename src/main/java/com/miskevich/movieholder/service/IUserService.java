package com.miskevich.movieholder.service;

import com.miskevich.movieholder.entity.Review;
import com.miskevich.movieholder.entity.User;

public interface IUserService {
    User getById(int id);
    Review enrichWithUser(Review review);
    User getByNickname(String nickname);
    User getDefaultUser();
}
