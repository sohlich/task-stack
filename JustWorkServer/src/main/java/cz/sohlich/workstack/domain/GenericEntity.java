/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sohlich.workstack.domain;

import org.springframework.data.annotation.Id;

/**
 *
 * @author radek
 */
public abstract class GenericEntity {

    @Id
    String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
