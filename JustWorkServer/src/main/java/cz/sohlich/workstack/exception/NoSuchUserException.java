/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sohlich.workstack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author radek
 */
@ResponseStatus(value=HttpStatus.NO_CONTENT, reason="No Such User")
public class NoSuchUserException extends Throwable {    
}
