package com.meecky.springBlogApi.users.controller;

import com.meecky.springBlogApi.users.dto.*;
import com.meecky.springBlogApi.users.DaoService.usersDaoService;
import com.meecky.springBlogApi.users.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("users")
public class UsersController {


    private usersDaoService service;

    public UsersController(usersDaoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<userResponseDto> getUsersList(){
        return ResponseEntity.ok(new userResponseDto("Operation successful", 0, Optional.of(service.findAll())));
    }

    @GetMapping("/{id}")
    public ResponseEntity<userResponseDto> getUsers(@PathVariable long id){
        userDto responseVal = service.findById(id);
        if (responseVal == null)
            throw new UserNotFoundException("Data For User With Id: " + id + " Not Found");
        return ResponseEntity.ok(new userResponseDto("Operation successful", 0, Optional.of(responseVal)));
    }

    @PostMapping("/")
    public ResponseEntity<userResponseDto> createUser(@Valid @RequestBody userDto user){
        userDto response = service.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new userResponseDto("user created successful", 0, Optional.of(response)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<userResponseDto> removeUser(@PathVariable long id){
        userDto removedUser = service.removeById(id);
        if (removedUser == null)
            throw new UserNotFoundException("User With Id: " + id + " dose not exist");
        return new ResponseEntity<userResponseDto>(new userResponseDto("Delete successfull", 0, Optional.of(removedUser)), HttpStatus.OK);
    }
}
