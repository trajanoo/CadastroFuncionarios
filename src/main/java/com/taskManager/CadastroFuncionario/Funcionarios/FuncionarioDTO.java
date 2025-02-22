package com.taskManager.CadastroFuncionario.Funcionarios;

import com.taskManager.CadastroFuncionario.Tasks.TaskModel;
import jakarta.persistence.*;

public class FuncionarioDTO {


    private Long id;
    private String nome;
    private String email;
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public TaskModel getTask() {
        return task;
    }

    public void setTask(TaskModel task) {
        this.task = task;
    }

    private TaskModel task;

}
