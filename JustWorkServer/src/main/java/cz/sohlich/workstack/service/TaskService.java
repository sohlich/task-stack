/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sohlich.workstack.service;

import cz.sohlich.workstack.api.dto.TaskDTO;
import org.springframework.stereotype.Service;

/**
 *
 * @author radek
 */
@Service
public interface TaskService {
    public TaskDTO createOrUpdateTask(TaskDTO task);
    public TaskDTO deleteTask(String id);
    public TaskDTO selectTask(String id);
}
