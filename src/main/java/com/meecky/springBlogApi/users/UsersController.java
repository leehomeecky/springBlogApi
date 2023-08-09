package com.meecky.springBlogApi.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("users")
public class UsersController {
    List<newUser> usersRecord = new ArrayList<>();
    @PostMapping("/")
    public ResponseEntity<newUser> createUesr(@RequestBody newUser user){
        usersRecord.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/")
    public ResponseEntity<List<newUser>> getUsersList(){
        return ResponseEntity.ok(usersRecord);
    }
}
