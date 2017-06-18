package com.miskevich.movieholder.dao;

import com.miskevich.movieholder.entity.User;

public interface IUserDao {
    User getById(int id);
    User getByNickname(String nickname);
    User getDefaultUser();
}
