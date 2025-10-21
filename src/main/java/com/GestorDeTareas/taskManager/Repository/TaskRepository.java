package com.GestorDeTareas.taskManager.Repository;

import com.GestorDeTareas.taskManager.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
