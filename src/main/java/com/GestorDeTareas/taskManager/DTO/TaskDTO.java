package com.GestorDeTareas.taskManager.DTO;

import com.GestorDeTareas.taskManager.Model.TaskState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private Long id;
    private String name;
    private String description;
    private TaskState state = TaskState.PENDING;
    private LocalDate deadline;
    
}
