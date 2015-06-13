/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sohlich.workstack.aspect;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 *
 * @author radek
 */
@Aspect
@Component
public class AuthorizationAspect {
    
    @Around("execution(* cz.sohlich.workstack.api.TaskResource.*(..))")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        Object[] array = pjp.getArgs();
        
        System.out.println(Arrays.toString(array));
        // start stopwatch
        Object retVal = pjp.proceed();
        // stop stopwatch
        return retVal;
    }
}
