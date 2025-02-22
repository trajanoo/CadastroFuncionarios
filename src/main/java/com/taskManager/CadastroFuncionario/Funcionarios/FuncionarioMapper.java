package com.taskManager.CadastroFuncionario.Funcionarios;

import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    public FuncionarioModel map(FuncionarioDTO funcionarioDTO) {
        FuncionarioModel funcionarioModel = new FuncionarioModel();

        funcionarioModel.setId(funcionarioDTO.getId());
        funcionarioModel.setNome(funcionarioDTO.getNome());
        funcionarioModel.setEmail(funcionarioDTO.getEmail());
        funcionarioModel.setStatus(funcionarioDTO.getStatus());
        funcionarioModel.setTask(funcionarioDTO.getTask());

        return funcionarioModel;
    }

    public FuncionarioDTO map(FuncionarioModel funcionarioModel) {
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();

        funcionarioDTO.setId(funcionarioModel.getId());
        funcionarioDTO.setNome(funcionarioModel.getNome());
        funcionarioDTO.setEmail(funcionarioModel.getEmail());
        funcionarioDTO.setStatus(funcionarioModel.getStatus());
        funcionarioDTO.setTask(funcionarioModel.getTask());

        return funcionarioDTO;
    }
}
