package br.com.dsn.pack.karoo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dsn.pack.karoo.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository <Funcionario , Long> {

	Optional<Funcionario> findById (Long Id);
	
}