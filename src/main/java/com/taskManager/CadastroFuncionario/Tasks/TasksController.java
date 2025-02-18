package com.taskManager.CadastroFuncionario.Tasks;

import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private final TasksService TasksService;

    public TasksController(TasksService TasksService) {
        this.TasksService = TasksService;
    }

    @PostMapping("/adicionarTask")
    public String adicionarTask() {
        return "Task adicionada com sucesso!";
    }

    // Read:
    @GetMapping("/listarTasks")
    public List<TaskModel> listarTasks() {
        return TasksService.listarTasks();
    }

    // Update:
    @PutMapping("/atualizarTask")
    public String atualizarTasks() {
        return "Funcionario atualizado com sucesso!";
    }

    // Delete:
    @DeleteMapping("/removerTask")
    public String removerTasks() {
        return "Funcionario removido com sucesso!";
    }


}
