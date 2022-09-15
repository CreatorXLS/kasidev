package com.kasidev.controller;

import com.kasidev.dt.UserDTO;
import com.kasidev.entity.User;
import com.kasidev.service.GroupService;
import com.kasidev.service.UserService;
import com.kasidev.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    private GroupService groupService;

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO user){
        return userService.createUser(user);
    }
    @GetMapping("/user/{id}")
    public UserDTO getUserById(@PathVariable("id")Long id){
        return userService.getUserById(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long id, @RequestBody  UserDTO user){

        return new ResponseEntity<>(userService.updateUser(user, id), HttpStatus.OK);
    }
}
