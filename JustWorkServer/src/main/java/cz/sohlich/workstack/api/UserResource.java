/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sohlich.workstack.api;

import cz.sohlich.workstack.api.dto.UserDTO;
import cz.sohlich.workstack.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author radek
 */
@RestController
@RequestMapping("api/user")
public class UserResource {

    @Autowired UserServiceImpl userService;

    public UserDTO register(UserDTO user) {
        return userService.registerUser(user);
    }
}
