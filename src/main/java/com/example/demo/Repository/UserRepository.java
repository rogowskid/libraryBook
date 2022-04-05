package com.example.demo.Repository;


import com.example.demo.Entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface UserRepository  extends JpaRepository<UserData, Integer> {


   //public List<UserData> findByuserLogin(String userLogin);

   public UserData findByuserLogin(String userLogin);
   List<UserData> findByuserLoginNotContaining(String username);

}
