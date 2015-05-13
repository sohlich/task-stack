/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sohlich.workstack.service.impl;

import cz.sohlich.workstack.api.dto.UserDTO;
import cz.sohlich.workstack.domain.User;
import cz.sohlich.workstack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author radek
 */
@Component
public class UserServiceImpl {

    @Autowired PasswordEncoder encoder;
    @Autowired UserRepository userRepository;

    public UserDTO registerUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setPassword(encoder.encode(userDTO.getRawPassword()));
        user = userRepository.save(user);

        //refresh dto
        userDTO.setId(user.getId());
        userDTO.setPassword(null);
        return userDTO;
    }
}
