package com.kasidev.service;

import com.kasidev.dt.GroupDTO;
import com.kasidev.entity.Group;
import com.kasidev.entity.User;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    Group createGroup(Group group);

    GroupDTO addUserToGroup(GroupDTO group);


    Group removeUserFromGroup(Long groupId, Long userId);

    Optional<Group> findGroupById(Long id);

    List<User> findGroupUsers(Long id);

    Group save(Group group);

}
