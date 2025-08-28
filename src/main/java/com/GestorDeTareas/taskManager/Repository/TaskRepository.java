package com.GestorDeTareas.taskManager.Repository;

import com.GestorDeTareas.taskManager.Model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepository {
    private final List<Task> tasks = new ArrayList<>();
    private long nextId = 1;

    public List<Task> findAll(){
        return new ArrayList<>(tasks);
    }

    public Optional<Task> findById(Long id){
        return tasks.stream().filter(t -> t.getId().equals(id)).findFirst();
    }

    public Task save(Task task){
        findById(task.getId()).ifPresent(tasks::remove);
        tasks.add(task);
        return task;
    }

    public void delete(Task task){
        tasks.remove(task);
    }
}
