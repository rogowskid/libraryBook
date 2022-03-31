package com.example.demo.Entity;

import lombok.Data;

@Data
public class BorrowBook {
    String idUser;
    String nameBook;
    String AuthorBok;
    String yearofPub;
    String ISBN;
    String dateofRet;
    public BorrowBook(String idUser, String nameBook, String authorBok, String yearofPub, String ISBN, String dateofRet) {
        this.idUser = idUser;
        this.nameBook = nameBook;
        this.AuthorBok = authorBok;
        this.yearofPub = yearofPub;
        this.ISBN = ISBN;
        this.dateofRet = dateofRet;
    }
}
