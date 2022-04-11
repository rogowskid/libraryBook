package com.example.demo.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class UserData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    private String userLogin;
    private String userPassword;
    private String nameUser;
    private String surNameUser;
    private String dateOfBirthday;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "user_data_roles",
    joinColumns = @JoinColumn(name = "user_data_id_user"),
            inverseJoinColumns = @JoinColumn(name = "roles_id_role")
    )
    private Set<RoleUser> roles = new HashSet<>();



    public void setRoles(Set<RoleUser> roles) {

        this.roles = roles;
    }



}

