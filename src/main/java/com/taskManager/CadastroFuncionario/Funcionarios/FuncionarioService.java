package com.taskManager.CadastroFuncionario.Funcionarios;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionariosRepository funcionariosRepository;

    public FuncionarioService(FuncionariosRepository funcionariosRepository) {
        this.funcionariosRepository = funcionariosRepository;
    }

    // listar todos
    public List<FuncionarioModel> listarTodos() {
        return funcionariosRepository.findAll();
    }

    // listar por id
    public FuncionarioModel listarPorID(Long id) {
        Optional<FuncionarioModel> funcionario = funcionariosRepository.findById(id);
        return funcionario.orElse(null);
    }

    // criar
    public FuncionarioModel criarFuncionario(FuncionarioModel funcionario) {
        return funcionariosRepository.save(funcionario);
    }


    // deletar (por id)
    public void removerFuncionario(Long id) {
        funcionariosRepository.deleteById(id);
    }


    // atualizar
    public FuncionarioModel alterarFuncionario(Long id, FuncionarioModel novoFuncionario) {
        if(funcionariosRepository.existsById(id)) {
            novoFuncionario.setId(id);
            return funcionariosRepository.save(novoFuncionario);
        } else {
            return null;
        }
    }

}
