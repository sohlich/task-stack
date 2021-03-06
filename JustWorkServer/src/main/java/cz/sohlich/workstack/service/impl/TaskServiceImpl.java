/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sohlich.workstack.service.impl;

import cz.sohlich.workstack.exception.NoSuchUserException;
import cz.sohlich.workstack.api.dto.TaskDTO;
import cz.sohlich.workstack.domain.Task;
import cz.sohlich.workstack.repository.TaskRepository;
import cz.sohlich.workstack.service.TaskService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author radek
 */
@Component
public class TaskServiceImpl implements TaskService {

    @Autowired TaskRepository taskRepository;

    @Override
    public TaskDTO createOrUpdateTask(TaskDTO dto) {

        Task task = dto.getId() != null ? taskRepository.findOne(dto.getId()) : null;

        if (task == null) {
            task = new Task();
        }

        //Merge result with DTO
        if (dto.getName() != null) {
            task.setName(dto.getName());
        }
        if (dto.getOrder() != null) {
            task.setOrder(dto.getOrder());
        }
        if (dto.getDeadline() != null) {
            task.setDeadline(dto.getDeadline());
        }
        if (dto.getDescription() != null) {
            task.setDescription(dto.getDescription());
        }
        if (dto.getEstimatedTime() != null) {
            task.setEstimatedTime(dto.getEstimatedTime());
        }
        if (dto.getPriority() != null) {
            task.setPriority(dto.getPriority());
        }
        if (dto.getTags() != null) {
            task.setTags(dto.getTags());
        }
        if (dto.getUser() != null) {
            task.setUser(dto.getUser());
        }

        task = taskRepository.save(task);
        return new TaskDTO(task);
    }

    @Override
    public TaskDTO deleteTaskByIdAndUser(String id,String userId) {
        Task task = taskRepository.findOneByIdAndUser(id,userId);
        TaskDTO result = new TaskDTO(task);
        taskRepository.delete(id);
        return result;

    }

    @Override
    public TaskDTO selectTask(String id) {
        Task task = taskRepository.findOne(id);
        TaskDTO result = new TaskDTO(task);
        return result;
    }

    @Override
    public List<TaskDTO> selectAllByUserId(String userId) throws NoSuchUserException {  
        if (userId == null) {throw new NoSuchUserException();}
        List<Task> tasks = taskRepository.findAllByUser(userId);
        return tasks.stream().map(TaskDTO::new).collect(Collectors.toList());
    }

}
