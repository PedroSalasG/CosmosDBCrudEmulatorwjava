package com.cosmos.cosmos.service.impl;

import com.cosmos.cosmos.models.User;
import com.cosmos.cosmos.models.dto.UserCrudResponse;
import com.cosmos.cosmos.repository.UserRepository;
import com.cosmos.cosmos.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userReppository) {
        this.userRepository = userReppository;
    }


    @Override
    public List<User> listarUsuarios() {
        List<User> userList = new ArrayList<>();
        log.info("Id is not present in the GET request");
        userList = userRepository.getAllUsers();
        return userList;
    }

   @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

}
