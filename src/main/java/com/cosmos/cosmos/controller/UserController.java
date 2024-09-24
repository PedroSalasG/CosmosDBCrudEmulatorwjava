package com.cosmos.cosmos.controller;

import com.cosmos.cosmos.models.User;
import com.cosmos.cosmos.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/hola/v1")
public class UserController {

    @Autowired
    private UserRepository userRepo;


    @PostMapping
    public ResponseEntity<User> createNewUser(@RequestBody User c) {

        c = userRepo.save(c);
        User user = new User();
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    //Update existing User
    @PutMapping("/{id}")
    public ResponseEntity<String> updateExistingUser(@PathVariable String id, @RequestBody User c) {

        userRepo.save(c);
        return new ResponseEntity<String>("", HttpStatus.NO_CONTENT);
    }


    //get customer details
    @GetMapping("/{id}")
    public ResponseEntity<List<User>> getUsers(@PathVariable String id) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("ContentType", "application/json");
        List<User> customerList = new ArrayList<>();

        log.info("Id is present in the GET request");
        List<Optional<User>> optionaUserList = Collections.singletonList(userRepo.findById(id));
        if (!(optionaUserList.get(0).isEmpty())) {
            optionaUserList.stream().forEach(c -> c.ifPresent(customer -> customerList.add(customer)));
            return new ResponseEntity<List<User>>(customerList, responseHeaders, HttpStatus.OK);
        }


        return new ResponseEntity<List<User>>(customerList, responseHeaders, HttpStatus.NOT_FOUND);

    }

    @GetMapping("/todos")
    public ResponseEntity<List<User>> getAllUsers() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("ContentType", "application/json");
        List<User> customerList = new ArrayList<>();

        log.info("Id is not present in the GET request");
        customerList = (List<User>) userRepo.findAll();
        return new ResponseEntity<List<User>>(customerList, responseHeaders, HttpStatus.OK);

    }


}
