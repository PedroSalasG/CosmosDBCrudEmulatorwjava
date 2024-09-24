package com.cosmos.cosmos.controller;

import com.cosmos.cosmos.models.User;
import com.cosmos.cosmos.models.dto.UserCrudResponse;
import com.cosmos.cosmos.repository.UserRepository;
import com.cosmos.cosmos.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/hola/v1")
public class UserController {

   private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> crear(@RequestBody User user) {
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("todos")
    public ResponseEntity<?> getAllUsers() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("ContentType", "application/json");
        return new ResponseEntity<List<User>>(userService.listarUsuarios(), responseHeaders, HttpStatus.OK);
    }


}
