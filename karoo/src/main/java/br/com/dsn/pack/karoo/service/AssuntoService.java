package br.com.dsn.pack.karoo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dsn.pack.karoo.domain.Assunto;
import br.com.dsn.pack.karoo.exceptions.AssuntoNotFoundException;
import br.com.dsn.pack.karoo.exceptions.AssuntoNotValidException;
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

	public Assunto getById(Long id) throws AssuntoNotFoundException {

		Optional<Assunto> assunto = assuntoRepository.findById(id);

		if (assunto.isPresent()) {
			return assunto.get();
		} else {
			throw new AssuntoNotFoundException(id);
		}
	}

	public String addAssunto(Assunto assunto) throws AssuntoNotValidException {

		if (assunto.ehvalido()) {
			assuntoRepository.save(assunto);
			return "Destaque criado com sucesso!";
		} else {
			throw new AssuntoNotValidException(assunto.getId());
		}
	}

	public Assunto updateAssunto(Assunto assunto) throws AssuntoNotValidException {

		if (assunto.ehvalido()) {
			return assuntoRepository.save(assunto);
		} else {
			throw new AssuntoNotValidException(assunto.getId());
		}
	}

	public String deleteAssunto(long id) throws AssuntoNotFoundException {

		Optional<Assunto> assunto = assuntoRepository.findById(id);

		if (assunto.isPresent()) {
			assuntoRepository.deleteById(id);
			return "Destaque removido com sucesso";
		} else {
			throw new AssuntoNotFoundException(id);
		}
	}
}