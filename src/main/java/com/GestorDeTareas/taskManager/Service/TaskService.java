package com.GestorDeTareas.taskManager.Service;

import com.GestorDeTareas.taskManager.DTO.TaskDTO;
import com.GestorDeTareas.taskManager.Model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final List<Task> repository = new ArrayList<>();
    private long nextId = 1;

    public List<Task> getAllTasks(){
        return new ArrayList<>(repository);
    }

    public Task createTask(TaskDTO taskDTO){
        Task task = new Task();
        task.setId(nextId++);
        task.setName(taskDTO.getName());
        task.setDesc(taskDTO.getDesc());
        task.setState(taskDTO.isState());
        task.setDeadline(taskDTO.getDeadline());
        repository.add(task);

        return task;
    }

    public Task getTaskById(Long id){
        return repository.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Task updateTask(Long id, TaskDTO taskDTO){
        Optional<Task> optTask = repository.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
        if(optTask.isPresent()){
            Task task = optTask.get();
            task.setName(taskDTO.getName());
            task.setDesc(taskDTO.getDesc());
            task.setState(taskDTO.isState());
            task.setDeadline(taskDTO.getDeadline());
            return task;
        }

        return null;
    }

    public boolean deleteTask(Long id){
        return repository.removeIf(t -> t.getId().equals(id));
    }
}
