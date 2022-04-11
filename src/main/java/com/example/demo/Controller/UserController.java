package com.example.demo.Controller;

import com.example.demo.Entity.UserData;
import com.example.demo.Repository.RoleUserRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Session.SessionController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@AllArgsConstructor
@RequestMapping
public class UserController {

    private UserRepository userRepository;
    private RoleUserRepository roleUserRepository;


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

    @GetMapping ("/user")
    public String showUser(Model model)
    {

        String username = sessionController.getSessionUserLogin();
        List<UserData> user  = userRepository.findByuserLoginNotContaining(username);

        model.addAttribute("users", user);


        return "/listUser";

    }

    @GetMapping("/userdelete")
    public String deleteUser(@RequestParam(name = "id") int idUser)
    {


        userRepository.deleteById(idUser);

        return "redirect:/user";

    }








}
