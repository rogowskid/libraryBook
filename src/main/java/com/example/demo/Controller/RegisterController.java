package com.example.demo.Controller;

import com.example.demo.Entity.RoleUser;
import com.example.demo.Entity.UserData;
import com.example.demo.Repository.RoleUserRepository;
import com.example.demo.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Controller
@AllArgsConstructor
@RequestMapping
public class RegisterController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleUserRepository roleUserRepository;
    @GetMapping("/register")
    public String index(Model model)
    {

        model.addAttribute("addUser", new UserData());
        return "/registerUser";

    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserData userData)
    {


        RoleUser roleUser = roleUserRepository.findById(1).get();
        Set<RoleUser> roles = new HashSet<>();
        roles.add(roleUser);
        userData.setRoles(roles);
        userData.setUserPassword(passwordEncoder.encode(userData.getUserPassword()));
        userRepository.save(userData);

        return "redirect:/login";
    }

}
