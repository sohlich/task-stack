/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sohlich.workstack.api;

import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author radek
 */
@RestController
@RequestMapping(value = "/security")
public class SecurityResource {

    Logger log = LoggerFactory.getLogger(SecurityResource.class);

    @RequestMapping(value = "/login")
    public void login(HttpServletResponse response) {
        log.info("Redirected to login via REST");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

    }

}
