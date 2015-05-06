/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sohlich.workstack.repository;

import cz.sohlich.workstack.domain.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author radek
 */
public interface TaskRepository extends MongoRepository<Task, String>{
    
}
