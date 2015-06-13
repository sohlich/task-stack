/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sohlich.workstack.api;

import cz.sohlich.workstack.api.dto.TaskDTO;
import cz.sohlich.workstack.exception.NoSuchUserException;
import cz.sohlich.workstack.repository.auditing.TaskSecurityAuditor;
import cz.sohlich.workstack.security.UserAuthentication;
import cz.sohlich.workstack.service.TaskService;
import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author radek
 */
@RestController
@RequestMapping(value = "api/task")
public class TaskResource {

    @Autowired TaskService taskService;

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<TaskDTO> selectAll() throws NoSuchUserException {
        return taskService.selectAllByUserId(getCurrentUser());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public TaskDTO selectOne(@PathVariable String id) {
        return taskService.selectTask(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public TaskDTO createOrUpdate(@RequestBody TaskDTO task) {
        task.setUser(getCurrentUser());
        return taskService.createOrUpdateTask(task);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public TaskDTO delete(@PathVariable String id) {
        return taskService.deleteTaskByIdAndUser(id, getCurrentUser());
    }

    private String getCurrentUser() {
        return ((UserAuthentication) SecurityContextHolder.getContext().getAuthentication()).getDetails().getId();
    }

}
