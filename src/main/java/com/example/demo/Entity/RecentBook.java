package com.example.demo.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class RecentBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecent;
    private int idUser;
    private Long idBook;
    private String dateOfReturn;


    public RecentBook(int idUser, Long idBook, String dateOfReturn) {
        this.idUser = idUser;
        this.idBook = idBook;
        this.dateOfReturn = dateOfReturn;
    }
}
