package com.GestorDeTareas.taskManager.Controller;

import com.GestorDeTareas.taskManager.DTO.TaskDTO;
import com.GestorDeTareas.taskManager.Service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private final TaskService service;

    public TaskController(TaskService service){
        this.service = service;
    }

    //Traer todas las tareas
    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks(){
        return ResponseEntity.ok(service.getAllTasks());
    }

    //Traer una tarea por un ID
    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id){
        return ResponseEntity.ok(service.getTask(id));
    }

    //Creando una tarea
    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO){
        TaskDTO createdTask = service.createTask(taskDTO);
        return ResponseEntity.ok(createdTask);
    }

    //Actualizando/modificando una tarea
    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id,
                                           @RequestBody TaskDTO taskDTO) {
        TaskDTO updatedTask = service.updateTask(id, taskDTO);
        return ResponseEntity.ok(updatedTask);
    }

    //Eliminando una tarea
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}
