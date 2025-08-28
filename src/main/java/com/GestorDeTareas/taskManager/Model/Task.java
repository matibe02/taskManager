package com.GestorDeTareas.taskManager.Model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Task {
    private Long id;
    private String name;
    private String desc;
    private boolean state; //Tres estados: No hecho, pendiente y realizado
    private LocalDate deadline;

    public Task(String name, String desc, boolean state, LocalDate deadline){
        this.name = name;
        this.desc = desc;
        this.state = state;
        this.deadline = deadline;
    }

    public Task(){

    }

}
