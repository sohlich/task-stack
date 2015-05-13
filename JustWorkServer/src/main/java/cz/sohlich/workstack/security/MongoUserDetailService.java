/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sohlich.workstack.security;

import cz.sohlich.workstack.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author radek
 */
@Component("userDetailsService")
public class MongoUserDetailService implements UserDetailsService {

    @Autowired UserRepository repository;
    @Autowired PasswordEncoder encoder;

    @PostConstruct
    public void postConstruct() {

        if (repository.findByUsername("admin") == null) {
            cz.sohlich.workstack.domain.User user = new cz.sohlich.workstack.domain.User();
            user.setUsername("admin");
            user.setFirstname("admin");
            user.setLastname("admin");
            user.setPassword(encoder.encode("admin"));
            repository.save(user);
        };

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        cz.sohlich.workstack.domain.User user = repository.findByUsername(username);

        if (user != null) {
            List<GrantedAuthority> authorities
                    = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(UserRoles.USER.toString()));
            return new User(username, user.getPassword(), authorities);

        }
        throw new UsernameNotFoundException(username + "not found");
    }

}
