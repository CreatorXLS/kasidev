package com.kasidev.service;

import com.kasidev.dt.UserDTO;
import com.kasidev.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(Long userId);

    UserDTO updateUser(UserDTO userDTO, Long userId);

    void deleteUser(Long userId);
}
