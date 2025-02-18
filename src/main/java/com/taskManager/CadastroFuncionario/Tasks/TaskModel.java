package com.taskManager.CadastroFuncionario.Tasks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.taskManager.CadastroFuncionario.Funcionarios.FuncionarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "db_tasks")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeTask;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private StatusConclusao statusConclusao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTask() {
        return nomeTask;
    }

    public void setNomeTask(String nomeTask) {
        this.nomeTask = nomeTask;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusConclusao getStatusConclusao() {
        return statusConclusao;
    }

    public void setStatusConclusao(StatusConclusao statusConclusao) {
        this.statusConclusao = statusConclusao;
    }

    public List<FuncionarioModel> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<FuncionarioModel> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "task", fetch = FetchType.EAGER)
    private List<FuncionarioModel> funcionarios;
}
