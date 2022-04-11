package com.example.demo.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;
    private String nameBook;
    private String author;
    private int yearofPublication;
    private String ISBN;


    public Book(Long idBook, String nameBook, String author, int yearofPublication, String ISBN) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.author = author;
        this.yearofPublication = yearofPublication;
        this.ISBN = ISBN;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearofPublication() {
        return yearofPublication;
    }

    public void setYearofPublication(int yearofPublication) {
        this.yearofPublication = yearofPublication;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
