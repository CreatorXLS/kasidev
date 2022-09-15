package com.kasidev;

import com.kasidev.dt.UserDTO;
import com.kasidev.entity.User;
import org.springframework.stereotype.Component;
@Component
public class UserConverter {




        public User convertDTOtoEntity(UserDTO userDTO){
            User userEntity = new User();
//            userEntity.(userDTO.getId());
//            userEntity.setUserName(userDTO.getUserName());
            return userEntity;
        }

        public UserDTO convertEntityToDTO(User userEntity){
            UserDTO userDTO = new UserDTO();
//            userDTO.setId(userEntity.getId());
//            userDTO.setUserName(userEntity.getUserName());
            return userDTO;
        }
    }

