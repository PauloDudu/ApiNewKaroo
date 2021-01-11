package br.com.dsn.pack.karoo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dsn.pack.karoo.domain.Destaque;
import br.com.dsn.pack.karoo.exceptions.DestaqueNotFoundException;
import br.com.dsn.pack.karoo.repository.DestaqueRepository;

@Service
public class DestaqueService {

	@Autowired
	DestaqueRepository destaqueRepository;

	public List<Destaque> getAll() throws DestaqueNotFoundException {

		List<Destaque> destaques = destaqueRepository.findAll();

		if (!destaques.isEmpty()) {
			return destaques;
		} else {
			throw new DestaqueNotFoundException();
		}
	}

	public Destaque getById(Long id) {

		Optional<Destaque> destaque = destaqueRepository.findById(id);

		return destaque.get();
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