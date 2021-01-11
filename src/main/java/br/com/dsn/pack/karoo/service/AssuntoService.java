package br.com.dsn.pack.karoo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dsn.pack.karoo.domain.Assunto;
import br.com.dsn.pack.karoo.exceptions.AssuntoNotFoundException;
import br.com.dsn.pack.karoo.repository.AssuntoRepository;

@Service
public class AssuntoService {

	@Autowired
	AssuntoRepository assuntoRepository;

	public List<Assunto> getAll() throws AssuntoNotFoundException {

		List<Assunto> assuntos = assuntoRepository.findAll();

		if (!assuntos.isEmpty()) {
			return assuntos;
		} else {
			throw new AssuntoNotFoundException();
		}
	}

	public Assunto getById(Long id) {

		Optional<Assunto> assunto = assuntoRepository.findById(id);

		return assunto.get();
	}

	public String addAssunto(Assunto assunto) {

		assuntoRepository.save(assunto);
		return "Destaque criado com sucesso!";
	}

	public Assunto updateAssunto(Assunto assunto) {

		return assuntoRepository.save(assunto);
	}

	public String deleteAssunto(long id) {

		assuntoRepository.deleteById(id);
		return "Destaque removido com sucesso";
	}
}