package com.example.demo.Security;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;



@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class LoginConfiguration extends WebSecurityConfigurerAdapter {


    private UserDetailsService userDetalisService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()


                .authorizeRequests()



                .anyRequest().authenticated()
                .and()

                    .formLogin()
                    .loginPage("/login").defaultSuccessUrl("/main", true)
                    .usernameParameter("login")
                    .passwordParameter("password")

                    .permitAll()
                .and()
                    .logout().permitAll()
                    .logoutUrl("/logout")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);



        http.headers().frameOptions().disable();



    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()

                .antMatchers("/css/*","/register","/h2-console/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetalisService);
    }
}
