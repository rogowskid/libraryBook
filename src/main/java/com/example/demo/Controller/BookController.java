package com.example.demo.Controller;

import com.example.demo.Entity.*;
import com.example.demo.Repository.BookRepository;
import com.example.demo.Repository.RecentBookRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.BookService;
import com.example.demo.Session.SessionController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class BookController {

    private BookRepository bookRepository;
    private BookService bookService;
    private RecentBookRepository recentBookRepository;
    private UserRepository userRepository;
    private final SessionController sessionController;

    public BookController(BookRepository bookRepository, BookService bookService,
                          RecentBookRepository recentBookRepository, UserRepository userRepository,
                          SessionController sessionController)
    {
        this.bookRepository = bookRepository;
        this.bookService = bookService;
        this.recentBookRepository = recentBookRepository;
        this.userRepository = userRepository;
        this.sessionController = sessionController;
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/addbook")
    public String index(Model model)
    {

        model.addAttribute("book", new Book());

        return "/addBook";

    }

    @PostMapping("/addbook")
    public String addBook(@ModelAttribute Book book)
    {


        bookRepository.save(book);
        return "redirect:/listofbook";
    }


    @GetMapping("/listofbook")
    public String printBOok(Model model)
    {
        List<Object[]> books = null;
        List<Book> book = new ArrayList<>();

        books = bookRepository.listBookQuery();

        for(Object[] obj : books)
        {
            book.add(new Book(Long.parseLong(String.valueOf(obj[0])),obj[3].toString(),obj[2].toString(),Integer.parseInt(String.valueOf(obj[4])),obj[1].toString()));
        }

        model.addAttribute("books", book);
        return "/listOfBooks";
    }

    @GetMapping("/listofbookfilter")
    public String filterPrintBook(@RequestParam(name="id") String bookName, Model model)
    {
        List<Book> book = new ArrayList<>();
        List<Object[]> filterBooks = null;

        filterBooks = bookRepository.filterListBookQuery(bookName);


        for(Object[] obj : filterBooks)
        {
            book.add(new Book(Long.parseLong(String.valueOf(obj[0])),obj[3].toString(),obj[2].toString(),Integer.parseInt(String.valueOf(obj[4])),obj[1].toString()));
        }

        model.addAttribute("books", book);

        return "/listOfBooks";
    }



    @GetMapping("/rentbooks")
    public String printRentBook(@RequestParam(name = "id") Long idBookName, Model model)
    {

        Book book;
        book = bookRepository.findById(idBookName).get();
        model.addAttribute("bookOfBorrow", book);



        return "/rentBook";
    }


    @GetMapping("/rentbook")
    public String postPrintBook(@RequestParam(name="idbook") Long idBookName)
    {


        bookService.borrowBook(idBookName);
        return "redirect:/listofbook";

    }


    @GetMapping("/returnbook")
    public String printReturnBook(Model model, RedirectAttributes redirectAttributes)
    {


        String username = sessionController.getSessionUserLogin();
        UserData userData = userRepository.findByuserLogin(username);
        Long idUser = Long.valueOf(userData.getIdUser());
        List<Object[]> recentBooks = null;
        List<BorrowBook> borrowBook = new ArrayList<>();

        recentBooks = recentBookRepository.customQuery(idUser);

        for(Object[] obj : recentBooks)
        {

            borrowBook.add(new BorrowBook(obj[0].toString(),obj[1].toString(),obj[2].toString(),obj[3].toString(), obj[4].toString(), obj[5].toString()));

        }


        if (borrowBook.size() == 0)
        {

            model.addAttribute("emptyBorrowBook", "Brak książek do zwrotu");
        }
        else
        {
            model.addAttribute("borrowBooks", borrowBook);
            redirectAttributes.addFlashAttribute("borrowBooks", borrowBook);
        }



        return "/returnBook";
    }


    @GetMapping("/borrowbook")
    public String returnBorrowBook(@RequestParam(name = "id") Integer idUser)
    {

        RecentBook recentBook;

        List<RecentBook> listOfBorrowBook = recentBookRepository.findByidUser(idUser);
        recentBook = listOfBorrowBook.get(0);
        recentBookRepository.delete(recentBook);


        return "redirect:/returnbook";
    }



}
