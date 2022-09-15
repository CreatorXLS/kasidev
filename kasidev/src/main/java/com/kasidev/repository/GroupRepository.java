package com.kasidev.repository;

import com.kasidev.entity.Group;
import com.kasidev.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {

    Group findGroupById(Long groupId);

//    Group add(User user);
}
