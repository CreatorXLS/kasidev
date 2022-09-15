package com.kasidev.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "GROUP_TABLE")
public class Group {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String groupName;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "group_users",
            joinColumns = { @JoinColumn(name = "id") },
            inverseJoinColumns = { @JoinColumn(name = "USER_ID")})

    private Set<User> users = new HashSet<>();

    public void addUser(User user) {
        users.add(user);
    }
}
