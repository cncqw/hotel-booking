package edu.dali.hotel.service.implement;

import edu.dali.hotel.model.UserEntity;
import edu.dali.hotel.repository.UserRepository;
import edu.dali.hotel.service.UserService;
import edu.dali.hotel.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity checkUser(String username, String password) {
        UserEntity user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
