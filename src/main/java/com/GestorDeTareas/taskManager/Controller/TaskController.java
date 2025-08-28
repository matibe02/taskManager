package com.GestorDeTareas.taskManager.Controller;

import com.GestorDeTareas.taskManager.DTO.TaskDTO;
import com.GestorDeTareas.taskManager.Model.Task;
import com.GestorDeTareas.taskManager.Service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
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
        List<TaskDTO> tasks = service.getAllTasks()
                .stream()
                .map(TaskDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tasks);
    }

    //Traer una tarea por un ID
    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id){
        Task task = service.getTaskById(id);
        if(task != null){
            return ResponseEntity.ok(new TaskDTO(task));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    //Creando una tarea
    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO){
        Task createdTask = service.createTask(taskDTO);
        return ResponseEntity.ok(new TaskDTO(createdTask));
    }

    //Actualizando/modificando una tarea
    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id,
                                           @RequestBody TaskDTO taskDTO) {
        Task updatedTask = service.updateTask(id, taskDTO);
        if(updatedTask != null){
            return ResponseEntity.ok(new TaskDTO(updatedTask));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    //Eliminando una tarea
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        boolean deleted = service.deleteTask(id);
        if(deleted){
            return ResponseEntity.noContent().build(); // 204
        }
        else{
            return ResponseEntity.notFound().build(); //404
        }
    }
}
