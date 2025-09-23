package com.GestorDeTareas.taskManager.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private boolean state; //Tres estados: No hecho, pendiente y realizado
    private LocalDate deadline;

    public Task(String name, String description, boolean state, LocalDate deadline){
        this.name = name;
        this.description = description;
        this.state = state;
        this.deadline = deadline;
    }

}
