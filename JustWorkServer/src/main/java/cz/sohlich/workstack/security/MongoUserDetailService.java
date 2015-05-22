/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sohlich.workstack.security;

import cz.sohlich.workstack.domain.User;
import cz.sohlich.workstack.domain.UserAuthority;
import cz.sohlich.workstack.repository.UserRepository;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author radek
 */
@Component("userDetailsService")
public class MongoUserDetailService implements UserDetailsService {

    @Autowired UserRepository repository;
    PasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostConstruct
    public void postConstruct() {

        if (repository.findByUsername("admin") == null) {
            cz.sohlich.workstack.domain.User user = new cz.sohlich.workstack.domain.User();
            user.setUsername("admin");
            user.setFirstname("admin");
            user.setLastname("admin");
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            user.setEnabled(true);
            user.setPassword(encoder.encode("admin"));
            user.setAuthorities(Arrays.asList(new UserAuthority("USER"),new UserAuthority("ADMIN")));
            user.setExpires(Long.MAX_VALUE);
            repository.save(user);
        };

    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        cz.sohlich.workstack.domain.User user = repository.findByUsername(username);

        if (user != null) {
            return user;

        }
        throw new UsernameNotFoundException(username + "not found");
    }

}
