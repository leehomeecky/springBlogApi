package com.meecky.springBlogApi.users.controller;

import com.meecky.springBlogApi.users.dto.*;
import com.meecky.springBlogApi.users.DaoService.usersDaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("users")
public class UsersController {


    private usersDaoService service;

    public UsersController(usersDaoService service) {
        this.service = service;
    }
    //    @PostMapping("/")
//    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
//        usersRecord.add(user);
//        return ResponseEntity.status(HttpStatus.CREATED).body(user);
//    }

    @GetMapping("/")
    public ResponseEntity<userResponse> getUsersList(){
        return ResponseEntity.ok(new userResponse("Operation successful", 0, Optional.of(service.findAll())));
    }

    @GetMapping("/{id}")
    public ResponseEntity<userResponse> getUsers(@PathVariable long id){
        userDto responseVal = service.findById(id);
        if (responseVal == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new userResponse("Data Not Found", -1));
        return ResponseEntity.ok(new userResponse("Operation successful", 0, Optional.of(responseVal)));
    }

    @PostMapping("/")
    public ResponseEntity<userResponse> createUser(@RequestBody userDto user){
        userDto response = service.createUser(user);
        if (response == null)
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new userResponse("user with id already exist, id must be unique", -1));
        return ResponseEntity.status(HttpStatus.CREATED).body(new userResponse("user created successful", 0, Optional.of(response)));
    }
}
