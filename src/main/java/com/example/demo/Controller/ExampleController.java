package com.example.demo.Controller;

import com.example.demo.Entity.Book;
import com.example.demo.Repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/test")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class ExampleController {

    BookRepository bookRepository;


    @GetMapping
    public List<Book> index()
    {
        List<Book> books;
        books = bookRepository.findAll();
        return books;
    }



}
