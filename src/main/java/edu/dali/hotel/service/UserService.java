package edu.dali.hotel.service;

import edu.dali.hotel.model.UserEntity;

public interface UserService {
    UserEntity checkUser(String username, String password);
}
