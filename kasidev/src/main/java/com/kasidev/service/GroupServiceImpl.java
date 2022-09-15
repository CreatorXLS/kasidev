package com.kasidev.service;

import com.kasidev.GroupConverter;
import com.kasidev.dt.GroupDTO;
import com.kasidev.entity.Group;
import com.kasidev.entity.User;
import com.kasidev.repository.GroupRepository;
import com.kasidev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupConverter groupConverter;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }


    @Override
    public GroupDTO addUserToGroup(GroupDTO groupDTO) {

        User optionalUser = userRepository.findUserById(groupDTO.getUserId()).orElseThrow();
        Group groupFind = groupRepository.findGroupById(groupDTO.getId());
        groupFind.addUser(optionalUser);
        groupRepository.save(groupFind);
//            group = groupConverter.convertDTOtoEntity(groupDTO);

//            group = groupRepository.save(group);
        groupDTO = groupConverter.convertEntityToDTO(groupFind);
        return groupDTO;
//        User user = userRepository.findById(userId).orElseThrow(() -> {
//            throw new RuntimeException("User with id " + userId + " does not ex");
//        });
//        Group group = groupRepository.findById(groupId).orElseThrow();
//        group.addUser(user);
//        return groupRepository.save(group);
    }

    @Override
    public Group removeUserFromGroup(Long groupId, Long userId) {
        return null;
    }

    @Override
    public Optional<Group> findGroupById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> findGroupUsers(Long id) {
        return null;
    }

    @Override
    public Group save(Group group) {
        return null;
    }
}
