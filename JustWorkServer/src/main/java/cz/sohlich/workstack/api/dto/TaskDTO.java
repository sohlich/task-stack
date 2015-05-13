/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sohlich.workstack.api.dto;

import cz.sohlich.workstack.domain.Task;
import java.util.Date;
import java.util.List;

/**
 *
 * @author radek
 */
public class TaskDTO {

    String id;
    String name;
    Integer estimatedTime;
    Date deadline;
    String description;
    List<String> tags;
    String user;
    Integer priority;
    Integer order;
    String category;

    public TaskDTO() {
    }

    public TaskDTO(Task entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.estimatedTime = entity.getEstimatedTime();
        this.deadline = entity.getDeadline();
        this.description = entity.getDescription();
        this.tags = entity.getTags();
        this.user = entity.getUser();
        this.priority = entity.getPriority();
        this.order = entity.getPriority();
        this.category = entity.getCategory();
        this.order = entity.getOrder();
    }

    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Integer estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
    
    
}
