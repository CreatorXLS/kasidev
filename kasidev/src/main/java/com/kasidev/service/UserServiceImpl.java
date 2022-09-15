package com.kasidev.service;

import com.kasidev.UserConverter;
import com.kasidev.dt.GroupDTO;
import com.kasidev.dt.UserDTO;
import com.kasidev.entity.User;
import com.kasidev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userCoverter;


    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User userEntity = userCoverter.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        UserDTO dto = userCoverter.convertEntityToDTO(userEntity);

        return dto;
    }

    @Override
    public UserDTO getUserById(Long userId) {

        Optional<User> userOp = userRepository.findUserById(userId);
        UserDTO userDTO = null;
        if(userOp.isPresent()){
            User user = userOp.get();
            userDTO = userCoverter.convertEntityToDTO(user);
            userRepository.save(user);
        }
        return userDTO;

//        List<User> userEntityList = userRepository.findAll();
//        List<UserDTO> userDTOList = new ArrayList<>();
//        for (User userEntity : userEntityList) {
//            UserDTO userDTO = userCoverter.convertEntityToDTO(userEntity);
//            userDTOList.add(userDTO);
//
//        }
//        return userDTOList;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long userId) {
        Optional<User> userEntityOptional = userRepository.findById(userId);
        UserDTO userDTO1 = null;
        if (userEntityOptional.isPresent()) {
            User userEntity = userEntityOptional.get();
            userEntity.setUserName(userDTO.getUserName());
            userDTO1 = userCoverter.convertEntityToDTO(userEntity);
            userRepository.save(userEntity);
        }
        return userDTO1;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}