package com.kasidev;

import com.kasidev.dt.GroupDTO;
import com.kasidev.entity.Group;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class GroupConverter {

    public Group convertDTOtoEntity(GroupDTO groupDTO){
        Group group = new Group();
//        group.setId(groupDTO.getId());
        group.setGroupName(groupDTO.getGroupName());
        return group;
    }

    public GroupDTO convertEntityToDTO(Group group){
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setId(group.getId());
        groupDTO.setGroupName(group.getGroupName());
        groupDTO.setUserId(groupDTO.getUserId());
        return groupDTO;
    }
}
