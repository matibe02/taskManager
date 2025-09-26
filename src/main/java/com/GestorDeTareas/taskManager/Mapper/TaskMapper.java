package com.GestorDeTareas.taskManager.Mapper;

import com.GestorDeTareas.taskManager.DTO.TaskDTO;
import com.GestorDeTareas.taskManager.Model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskDTO toDTO(Task task){
        if (task == null) return null;
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setName(task.getName());
        dto.setDescription(task.getDescription());
        dto.setState(task.getState());
        dto.setDeadline(task.getDeadline());
        return dto;
    }

    public Task toEntity(TaskDTO taskDTO){
        if(taskDTO == null) return null;

        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setName(taskDTO.getName());
        task.setDescription(taskDTO.getDescription());
        task.setState(taskDTO.getState());
        task.setDeadline(taskDTO.getDeadline());
        return task;
    }
}
