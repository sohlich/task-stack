/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sohlich.workstack.repository.auditing;

import cz.sohlich.workstack.security.UserAuthentication;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author radek
 */
public class TaskSecurityAuditor implements AuditorAware<String>{

    @Override
    public String getCurrentAuditor() {
        return ((UserAuthentication)SecurityContextHolder.getContext().getAuthentication()).getDetails().getId();
    }
    
}
