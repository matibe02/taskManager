package com.GestorDeTareas.taskManager.Controller;

import com.GestorDeTareas.taskManager.DTO.TaskDTO;
import com.GestorDeTareas.taskManager.Model.TaskState;
import com.GestorDeTareas.taskManager.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks/view")
public class TaskViewController {

    private final TaskService service;

    @Autowired
    public TaskViewController(TaskService service){
        this.service = service;
    }

    // Mostrar todas las tareas
    @GetMapping
    public String listTasks(Model model){
        List<TaskDTO> tasks = service.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks"; // apunta al tasks.html
    }

    // Mostrar formulario para crear tarea
    @GetMapping("/form")
    public String showCreateForm(Model model){
        model.addAttribute("task", new TaskDTO());
        return "edit-task"; // apunta al edit-task.html
    }

    // Guardar tarea nueva
    @PostMapping("/save")
    public String saveTask(@ModelAttribute("task") TaskDTO taskDTO){
        service.createTask(taskDTO);
        return "redirect:/tasks/view";
    }

    // Mostrar formulario de edición
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        TaskDTO task = service.getTask(id);
        if (task.getState() == null) {
            task.setState(TaskState.PENDING); // seguridad
        }
        model.addAttribute("task", task);
        return "edit-task"; // apunta al edit-task.html
    }

    // Actualizar tarea existente
    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute("task") TaskDTO taskDTO){
        service.updateTask(id, taskDTO);
        return "redirect:/tasks/view";
    }

    // Eliminar tarea
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id){
        service.deleteTask(id);
        return "redirect:/tasks/view";
    }
}
