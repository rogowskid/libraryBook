package com.example.demo.Security;

import com.example.demo.Entity.RoleUser;
import com.example.demo.Entity.UserData;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;



public class MyUserDetalis implements UserDetails {

    private UserData userData;

    public MyUserDetalis(UserData userData) {
        this.userData = userData;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {


       Set<RoleUser> roles = userData.getRoles();
       List<SimpleGrantedAuthority> authorties = new ArrayList<>();

       for (RoleUser roleUser : roles)
       {
           authorties.add(new SimpleGrantedAuthority(roleUser.getNameRole()));
       }
       return authorties;
    }

    @Override
    public String getPassword() {

        if(userData==(null))
        {
            return null;
        }



        return userData.getUserPassword();
    }



    @Override
    public String getUsername() {
        return userData.getUserLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
