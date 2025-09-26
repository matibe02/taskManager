package com.GestorDeTareas.taskManager.Model;

import lombok.Getter;

@Getter
public enum TaskState {
    PENDING("Pendiente"),
    IN_PROGRESS("En progreso"),
    DONE("Finalizada");

    private final String displayName;

    TaskState(String displayName) {this.displayName = displayName;}

}
