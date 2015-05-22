/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sohlich.workstack.domain;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author radek
 */
@Document(collection = "app_users")
public class User extends GenericEntity implements UserDetails{
   
    String firstname, lastname;
    String username;
    String password;
    Long expires;
    boolean accountNonExpired,accountNonLocked,credentialsNonExpired,enabled;
    
    
    List<String> tags;
    List<String> categories;
    List<UserAuthority> authorities;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getExpires() {
        return expires;
    }

    public void setExpires(Long expires) {
        this.expires = expires;
    }

    @Override
    public List<UserAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<UserAuthority> authorities) {
        this.authorities = authorities;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }


    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    
    
    @Override
    public boolean isAccountNonExpired() {
       return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
         return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
         return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
         return enabled;
    }
    
    
    
    
}
