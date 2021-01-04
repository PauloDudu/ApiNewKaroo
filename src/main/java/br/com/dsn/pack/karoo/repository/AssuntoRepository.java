package br.com.dsn.pack.karoo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dsn.pack.karoo.domain.Assunto;

public interface AssuntoRepository extends JpaRepository <Assunto , Long> {
	
	Optional<Assunto> findById (Long Id);
}
