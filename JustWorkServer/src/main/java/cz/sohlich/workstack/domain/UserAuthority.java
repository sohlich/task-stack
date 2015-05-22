/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sohlich.workstack.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author radek
 */
public class UserAuthority implements GrantedAuthority{

    String authority;

    public UserAuthority() {
    }

    public UserAuthority(String authority) {
        this.authority = authority;
    }


    public void setAuthority(String authority) {
        this.authority = authority;
    }
    
    @Override
    public String getAuthority() {
        return authority;
        
    }
    
}
