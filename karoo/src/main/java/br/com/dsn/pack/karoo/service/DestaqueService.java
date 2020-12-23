package br.com.dsn.pack.karoo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dsn.pack.karoo.domain.Destaque;
import br.com.dsn.pack.karoo.exceptions.DestaqueNotFoundException;
import br.com.dsn.pack.karoo.exceptions.DestaqueNotValidException;
import br.com.dsn.pack.karoo.repository.DestaqueRepository;

@Service
public class DestaqueService {
	
	@Autowired
	DestaqueRepository destaqueRepository;
	
	public List<Destaque> getAll() throws DestaqueNotFoundException {
		
		List<Destaque> destaques = destaqueRepository.findAll();
		
		if(!destaques.isEmpty()) {
			return destaques;
		} else {
			throw new DestaqueNotFoundException();
		}
	}
	
	public Destaque getById(Long id) throws DestaqueNotFoundException {
		
		Optional<Destaque> destaque = destaqueRepository.findById(id);
		
		if(destaque.isPresent()) {
			return destaque.get();
		} else {
			throw new DestaqueNotFoundException(id);
		}
	}
	
	public String addDestaque(Destaque destaque) throws DestaqueNotValidException {
		
		if(destaque.ehvalido()) {
			destaqueRepository.save(destaque);
			return "Destaque criado com sucesso!";
		} else {
			throw new DestaqueNotValidException(destaque.getId());
		}
	}
	
	public Destaque updateDestaque(Destaque destaque) throws DestaqueNotValidException {
		
		if(destaque.ehvalido()) {
			return destaqueRepository.save(destaque);
		} else {
			throw new DestaqueNotValidException(destaque.getId());
		}
	}
	
	public String deleteDestaque(long id) throws DestaqueNotFoundException {
		
		Optional<Destaque> destaque = destaqueRepository.findById(id);
		
		if(destaque.isPresent()) {
			destaqueRepository.deleteById(id);
			return "Destaque removido com sucesso";
		} else {
			throw new DestaqueNotFoundException(id);
		}
	}
}