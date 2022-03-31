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

   /* @PostMapping("/login")
    public String accessLogin(@ModelAttribute UserData userData) throws Exception {

        String loginName = userData.getUserLogin();
        String passwordName = userData.getUserPassword();

        //List<UserData> userFind = userRepository.findByuserLogin(loginName);

        if (userFind.isEmpty()) {

            System.out.println("List is empty!");

        } else {

            UserData user = userFind.get(0);
            String loginNameDataBase = user.getUserLogin();


            if (loginName.equals(loginNameDataBase))
            {
                String passwordNameDataBase = user.getUserPassword();
                if(passwordName.equals(passwordNameDataBase))
                {

                    HttpSession session = request.getSession();
                    session.setAttribute("user", user.getIdUser());
                    return "redirect:/main";
                }


            }




        }
        return "redirect:/login";
    }*/




}
