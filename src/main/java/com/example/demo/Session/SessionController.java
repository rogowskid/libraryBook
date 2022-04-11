package com.example.demo.Session;

import com.example.demo.Security.MyUserDetalis;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SessionController {


    public String getSessionUserLogin()
    {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userlogin="";
        if (principal instanceof MyUserDetalis) {
            userlogin = ((MyUserDetalis)principal).getUsername();
        } else {
            userlogin = principal.toString();
        }




        return userlogin;
    }



}
