package com.taskManager.CadastroFuncionario.Funcionarios;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criar(@RequestBody FuncionarioDTO funcionario) {
        FuncionarioDTO funcionarioDTO = funcionarioService.criarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("O funcionario " + funcionario.getNome() + " foi criado com sucesso!");
    }

    // Read:
    @GetMapping("/listar")
    public ResponseEntity<List<FuncionarioDTO>> listar() {
        List<FuncionarioDTO> funcionarioLista = funcionarioService.listarTodos();

        return ResponseEntity.ok(funcionarioLista);
    }

    // Read by ID:
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarID(@PathVariable Long id) {

        FuncionarioDTO funcionario = funcionarioService.listarPorID(id);

        if(funcionario != null) {
            return ResponseEntity.ok()
                    .body(funcionario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro! O id: " + id + " não foi encontrado.");
        }
    }

    // Update:
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterar(@PathVariable Long id, @RequestBody FuncionarioDTO novoFuncionario) {

        FuncionarioDTO funcionario = funcionarioService.listarPorID(id);

        if(funcionario != null) {
            FuncionarioDTO funcionarioAtt = funcionarioService.atualizarFuncionario(id, novoFuncionario);
            return ResponseEntity.ok(funcionarioAtt);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro! O id: " + id + " não foi encontrado.");
        }
    }

    // Delete:
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<String> removerID(@PathVariable Long id) {
        if(funcionarioService.listarPorID(id) != null) {
            funcionarioService.removerFuncionario(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("O ID: " + id + " foi deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro! O id: " + id + " não foi encontrado.");
        }

    }
}
