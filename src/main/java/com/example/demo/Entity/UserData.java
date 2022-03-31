package com.example.demo.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

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

    public UserData(String userLogin, String userPassword, String nameUser, String surNameUser, String dateOfBirthday) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.nameUser = nameUser;
        this.surNameUser = surNameUser;
        this.dateOfBirthday = dateOfBirthday;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getSurNameUser() {
        return surNameUser;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }
}
