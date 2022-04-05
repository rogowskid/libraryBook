package com.example.demo.Security;

import com.example.demo.Entity.UserData;
import com.example.demo.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;




@Service
public class MyUserDetalisService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserData byuserLogin = userRepository.findByuserLogin(username);

        if (byuserLogin == null)
        {
            throw new UsernameNotFoundException("Could find user");
        }

        return new MyUserDetalis(byuserLogin);
    }
}
