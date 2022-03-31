package com.example.demo.Controller;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.UserData;
import com.example.demo.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping
public class RegisterController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    @GetMapping("/register")
    public String index(Model model)
    {

        model.addAttribute("addUser", new UserData());
        return "/registerUser";

    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserData userData)
    {

        userRepository.save(new UserData(userData.getUserLogin(), passwordEncoder.encode(userData.getUserPassword()),
                userData.getNameUser(), userData.getSurNameUser(), userData.getDateOfBirthday()));

        return "redirect:/login";
    }

}
