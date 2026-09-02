package com.example.DevSpring.Aula05.service;

import com.example.DevSpring.Aula05.model.Funcionario05;
import com.example.DevSpring.Aula05.repository.FuncionarioRepository05;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService05 {

    private final FuncionarioRepository05 funcionarioRepository05;

    public FuncionarioService05(FuncionarioRepository05 funcionarioRepository05) {
        this.funcionarioRepository05 = funcionarioRepository05;
    }

    public Funcionario05 save(Funcionario05 funcionario) {
        verificaFuncionario(funcionario);
        funcionario.setDepartamento(funcionario.getDepartamento().toUpperCase());
        return funcionarioRepository05.save(funcionario);
    }

    public List<Funcionario05> saveAll(List<Funcionario05> funcionarios) {
        if (funcionarios == null || funcionarios.isEmpty()) {
            throw new IllegalArgumentException("Lista deve ser preenchida!");
        }
        funcionarios.forEach(f -> {
            verificaFuncionario(f);
            f.setDepartamento(f.getDepartamento().toUpperCase());
        });
        return funcionarioRepository05.saveAll(funcionarios);
    }

    private void verificaFuncionario(Funcionario05 funcionario) {
        if (funcionario.getSalario() <= 2500) {
            throw new IllegalArgumentException(funcionario + " Salário deve ser maior que 2500!");
        }
        if (!Character.isUpperCase(funcionario.getNome().charAt(0))) {
            throw new IllegalArgumentException(funcionario + " Primeira letra do nome deve ser maiúscula!");
        }
        if (funcionario.getDepartamento().isBlank() || funcionario.getDepartamento().isEmpty()) {
            throw new IllegalArgumentException(funcionario + " Departamento deve ser preenchido!");
        }
    }
}