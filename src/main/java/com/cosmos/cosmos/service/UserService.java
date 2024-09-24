package com.cosmos.cosmos.service;

import com.cosmos.cosmos.models.User;
import com.cosmos.cosmos.models.dto.UserCrudResponse;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserService {

    public List<User> listarUsuarios();


    User saveUser(User user);

}
