package de.vkononenko.TacoCloud.configuration;

import de.vkononenko.TacoCloud.DAO.SystemUserDAO;
import de.vkononenko.TacoCloud.models.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class SecurityConfig {

    private SystemUserDAO systemUserDAO;

    @Autowired
    public SecurityConfig(SystemUserDAO systemUserDAO) {
        this.systemUserDAO = systemUserDAO;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) throws UsernameNotFoundException {
        List<UserDetails> usersList = new ArrayList<>();
        List<SystemUser> systemUserList = systemUserDAO.findAll();
        systemUserList.forEach(su -> {
            usersList.add(new User(su.getLogin(), su.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority(su.getRole()))));
        });
        return new InMemoryUserDetailsManager(usersList);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/design", "/orders").hasRole("USER")
                .antMatchers("/", "/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .usernameParameter("login")
                .passwordParameter("password")
                .defaultSuccessUrl("/design")
                .and().build();
    }
}