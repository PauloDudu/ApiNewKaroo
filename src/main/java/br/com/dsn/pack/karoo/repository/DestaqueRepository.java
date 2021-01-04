package br.com.dsn.pack.karoo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dsn.pack.karoo.domain.Destaque;

public interface DestaqueRepository extends JpaRepository <Destaque , Long> {

	Optional<Destaque> findById (Long Id);
	
}