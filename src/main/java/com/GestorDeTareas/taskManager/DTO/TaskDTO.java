package com.GestorDeTareas.taskManager.DTO;

import com.GestorDeTareas.taskManager.Model.Task;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDTO {
    private String name;
    private String desc;
    private boolean state;
    private LocalDate deadline;

    public TaskDTO(Task task){
        this.name = task.getName();
        this.desc = task.getDesc();
        this.state = task.isState();
        this.deadline = task.getDeadline();
    }

    public TaskDTO(){

    }
}
