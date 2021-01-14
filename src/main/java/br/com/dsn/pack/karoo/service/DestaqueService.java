package br.com.dsn.pack.karoo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dsn.pack.karoo.domain.Destaque;
import br.com.dsn.pack.karoo.repository.DestaqueRepository;
import javassist.NotFoundException;

@Service
public class DestaqueService {

	@Autowired
	DestaqueRepository destaqueRepository;

	public List<Destaque> getAll() {

		return destaqueRepository.findAll();
	}

	public Destaque getById(Long id) throws NotFoundException {
		
		Optional<Destaque> dest = destaqueRepository.findById(id);
		
		if(dest.isEmpty()) {
			throw new NotFoundException("Destaque nao encontrado");
		}
		return dest.get();
	}

	public String addDestaque(Destaque destaque) {

		destaqueRepository.save(destaque);
		return "Destaque criado com sucesso!";
	}

	public Destaque updateDestaque(Destaque destaque) {

		return destaqueRepository.save(destaque);
	}

	public String deleteDestaque(long id) {

		destaqueRepository.deleteById(id);
		return "Destaque removido com sucesso";
	}
}