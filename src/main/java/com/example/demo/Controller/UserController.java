package com.example.demo.Controller;



import com.example.demo.Entity.UserData;
import com.example.demo.Repository.UserRepository;

import com.example.demo.Session.SessionController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@AllArgsConstructor
@RequestMapping
public class UserController {

    private UserRepository userRepository;



    private final SessionController sessionController;


    @GetMapping("/login")
    public String indexLogin(Model model)
    {


        return "/login";

    }





    @GetMapping("/logout")
    public String logout()
    {



        return "redirect:/login";

    }

    @GetMapping("/main")
    public String index(Model model)
    {




        String username = sessionController.getSessionUserLogin();
        UserData user = userRepository.findByuserLogin(username);
        model.addAttribute("nameUser",user.getNameUser());



        return "/front";

    }






}
