package com.mudemy.user.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.ORDINAL)
    private RoleType name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
