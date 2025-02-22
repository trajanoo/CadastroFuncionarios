package com.taskManager.CadastroFuncionario.Funcionarios;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    private final FuncionariosRepository funcionariosRepository;
    private final FuncionarioMapper funcionarioMapper;

    public FuncionarioService(FuncionariosRepository funcionariosRepository, FuncionarioMapper funcionarioMapper) {
        this.funcionariosRepository = funcionariosRepository;
        this.funcionarioMapper = funcionarioMapper;
    }

    // listar todos
    public List<FuncionarioDTO> listarTodos() {
        List<FuncionarioModel> funcionarios = funcionariosRepository.findAll();

        return funcionarios.stream()
                .map(funcionarioMapper::map)
                .collect(Collectors.toList());
    }

    // listar por id
    public FuncionarioDTO listarPorID(Long id) {
        Optional<FuncionarioModel> funcionario = funcionariosRepository.findById(id);
        return funcionario.map(funcionarioMapper::map).orElse(null);

    }

    // criar
    public FuncionarioDTO criarFuncionario(FuncionarioDTO funcionarioDTO) {
        FuncionarioModel funcionario = funcionarioMapper.map(funcionarioDTO);
        funcionario = funcionariosRepository.save(funcionario);

        return funcionarioMapper.map(funcionario);
    }


    // deletar (por id)
    public void removerFuncionario(Long id) {
        funcionariosRepository.deleteById(id);
    }


    // atualizar
    public FuncionarioDTO atualizarFuncionario(Long id, FuncionarioDTO funcionarioDTO) {
        Optional<FuncionarioModel> funcionario = funcionariosRepository.findById(id);
        if(funcionario.isPresent()) {
            FuncionarioModel funcionarioAtualizado = funcionarioMapper.map(funcionarioDTO);
            funcionarioAtualizado.setId(id);
            FuncionarioModel funcionarioSalvo = funcionariosRepository.save(funcionarioAtualizado);

            return funcionarioMapper.map(funcionarioSalvo);
        } else {
            return null;
        }
    }

}
