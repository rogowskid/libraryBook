package com.example.demo.Service;

import com.example.demo.Entity.RecentBook;
import com.example.demo.Entity.UserData;
import com.example.demo.Repository.RecentBookRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Session.SessionController;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Service
public class BookService {


    RecentBookRepository recentBookRepository;
    UserRepository userRepository;
    final SessionController sessionController;

    public BookService(RecentBookRepository recentBookRepository, UserRepository userRepository, HttpServletRequest request, SessionController sessionController) {
        this.recentBookRepository = recentBookRepository;
        this.userRepository = userRepository;
        this.sessionController = sessionController;

    }

    public void borrowBook(Long bookId)
    {
        String nameuser = sessionController.getSessionUserLogin();
        UserData userData = userRepository.findByuserLogin(nameuser);

        Integer idUser = userData.getIdUser();

        RecentBook recentBook = new RecentBook(idUser,bookId, dateOfReturnMethod(1));

       recentBookRepository.save(recentBook);


    }

    public String dateOfReturnMethod(int x)
    {
        LocalDate localDate = LocalDate.now();
        LocalDate plusMonthDate = localDate.plusMonths(x);
        String dateForm = plusMonthDate.toString();

        return dateForm;
    }


}
