package com.taskManager.CadastroFuncionario.Tasks;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<TaskModel, Long> {
}
