package com.taskManager.CadastroFuncionario.Funcionarios;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    // CRUD: Create, Read, Update, Delete

    // Create:
    @PostMapping("/criar")
    public FuncionarioModel criar(@RequestBody FuncionarioModel funcionario) {
        return funcionarioService.criarFuncionario(funcionario);
    }

    // Read:
    @GetMapping("/listar")
    public List<FuncionarioModel> listar() {
        return funcionarioService.listarTodos();
    }

    // Read by ID:
    @GetMapping("/listar/{id}")
    public FuncionarioModel listarID(@PathVariable Long id) {
        return funcionarioService.listarPorID(id);
    }

    // Update:
    @PutMapping("/alterar/{id}")
    public FuncionarioModel alterar(@PathVariable Long id, @RequestBody FuncionarioModel novoFuncionario) {
        return funcionarioService.alterarFuncionario(id, novoFuncionario);
    }

    // Delete:
    @DeleteMapping("/remover/{id}")
    public void removerID(@PathVariable Long id) {
        funcionarioService.removerFuncionario(id);
    }

}
