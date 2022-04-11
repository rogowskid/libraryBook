package com.example.demo.Repository;

import com.example.demo.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository <Book, Long>{


    @Query(nativeQuery = true, value = "SELECT * \n" +
            "FROM book \n" +
            "WHERE id_book not in (SELECT id_book\n" +
            "FROM recent_book )")
    public List<Object[]> listBookQuery();

    @Query(nativeQuery = true, value = "SELECT * FROM book WHERE id_book not in (SELECT id_book FROM recent_book )\n" +
            "and book.name_book ILIKE CONCAT('%',:username,'%')")

    public List<Object[]> filterListBookQuery(String username);

}
