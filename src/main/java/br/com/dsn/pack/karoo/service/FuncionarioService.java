package br.com.dsn.pack.karoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dsn.pack.karoo.domain.Funcionario;
import br.com.dsn.pack.karoo.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioRepository funcionarioRepository;

	public List<Funcionario> getAll() {

		return funcionarioRepository.findAll();

	}

	public Funcionario getById(Long id) {

		return funcionarioRepository.findById(id).get();
	}

	public Funcionario addFuncionario(Funcionario funcionario) {

		funcionarioRepository.save(funcionario);
		return funcionario;
	}

	public Funcionario updateFuncionario(Funcionario funcionario) {

		return funcionarioRepository.save(funcionario);
	}

	public String deleteFuncionario(long id) {

		funcionarioRepository.deleteById(id);
		return "Funcionario removido com sucesso";

	}
}