package br.com.dsn.pack.karoo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dsn.pack.karoo.domain.Funcionario;
import br.com.dsn.pack.karoo.exceptions.FuncionarioNotFoundException;
import br.com.dsn.pack.karoo.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioRepository funcionarioRepository;

	public List<Funcionario> getAll() throws FuncionarioNotFoundException {

		List<Funcionario> funcionarios = funcionarioRepository.findAll();

		if (!funcionarios.isEmpty()) {
			return funcionarios;
		} else {
			throw new FuncionarioNotFoundException();
		}
	}

	public Funcionario getById(Long id) {

		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		return funcionario.get();
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