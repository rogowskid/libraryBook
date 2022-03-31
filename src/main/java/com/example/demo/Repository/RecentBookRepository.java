package com.example.demo.Repository;

import com.example.demo.Entity.RecentBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecentBookRepository  extends JpaRepository<RecentBook, Long> {

    @Query(nativeQuery = true, value = "select recent_book.id_user, book.name_book, book.author, book.yearof_publication, " +
            "book.isbn from recent_book " +
            "inner join book on recent_book.id_book = book.id_book " +
            "where recent_book.id_user = ?1")
    public List<Object[]> customQuery(Long idUser);

    public List<RecentBook> findByidUser(Integer idUser);



}
