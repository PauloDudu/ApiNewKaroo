package br.com.dsn.pack.karoo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dsn.pack.karoo.domain.Funcionario;
import br.com.dsn.pack.karoo.exceptions.FuncionarioNotFoundException;
import br.com.dsn.pack.karoo.exceptions.FuncionarioNotValidException;
import br.com.dsn.pack.karoo.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	public List<Funcionario> getAll() throws FuncionarioNotFoundException {
		
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		
		if(!funcionarios.isEmpty()) {
			return funcionarios;
		} else {
			throw new FuncionarioNotFoundException();
		}
	}
	
	public Funcionario getById(Long id) throws FuncionarioNotFoundException {
		
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		
		if(funcionario.isPresent()) {
			return funcionario.get();
		} else {
			throw new FuncionarioNotFoundException(id);
		}
	}
	
	public Funcionario addFuncionario(Funcionario funcionario) throws FuncionarioNotValidException {
		
		if(funcionario.ehvalido()) {
			funcionarioRepository.save(funcionario);
			return funcionario;
		} else {
			throw new FuncionarioNotValidException(funcionario.getId());
		}
	}
	
	public Funcionario updateFuncionario(Funcionario funcionario) throws FuncionarioNotValidException {
		
		if(funcionario.ehvalido()) {
	
			return funcionarioRepository.save(funcionario);
		} else {
			throw new FuncionarioNotValidException(funcionario.getId());
		}
	}
	
	public String deleteFuncionario(long id) throws FuncionarioNotFoundException {
		
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		
		if(funcionario.isPresent()) {
			funcionarioRepository.deleteById(id);
			return "Funcionario removido com sucesso";
		} else {
			throw new FuncionarioNotFoundException(id);
		}
	}
}