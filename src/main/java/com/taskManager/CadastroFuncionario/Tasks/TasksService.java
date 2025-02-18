package com.taskManager.CadastroFuncionario.Tasks;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksService {

    private TasksRepository tasksRepository;

    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public List<TaskModel> listarTasks() {
        return tasksRepository.findAll();
    }
}
