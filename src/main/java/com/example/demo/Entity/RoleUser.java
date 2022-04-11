package com.example.demo.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
public class RoleUser implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;
    private String nameRole;


    public RoleUser(int idRole, String nameRole) {
        this.idRole = idRole;
        this.nameRole = nameRole;
    }
}
