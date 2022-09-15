package com.kasidev.controller;


import com.kasidev.dt.GroupDTO;
import com.kasidev.entity.Group;
import com.kasidev.entity.User;
import com.kasidev.service.GroupService;
import com.kasidev.service.GroupServiceImpl;
import com.kasidev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class GroupController {

    @Autowired
    private GroupServiceImpl groupService;

    @Autowired
    private UserService userService;

    public GroupController(GroupServiceImpl groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/createGroup")
    public  Group createGroup(@RequestBody Group group){
        return groupService.createGroup(group);
    }

    @PostMapping("/addUserToGroup")
    public ResponseEntity<GroupDTO> addUserToGroup(@RequestBody GroupDTO groupDTO){
        groupService.addUserToGroup(groupDTO);

        return new ResponseEntity<>(groupDTO, HttpStatus.ACCEPTED);
    }
    

}
