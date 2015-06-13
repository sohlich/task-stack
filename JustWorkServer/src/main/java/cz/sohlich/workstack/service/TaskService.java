/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sohlich.workstack.service;

import cz.sohlich.workstack.api.dto.TaskDTO;
import cz.sohlich.workstack.exception.NoSuchUserException;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author radek
 */
@Service
public interface TaskService {
    public TaskDTO createOrUpdateTask(TaskDTO task);
    public TaskDTO deleteTaskByIdAndUser(String id,String userId);
    public TaskDTO selectTask(String id);
    public List<TaskDTO> selectAllByUserId(String userId) throws NoSuchUserException;
}
