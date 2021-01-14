package br.com.dsn.pack.karoo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dsn.pack.karoo.domain.Assunto;
import br.com.dsn.pack.karoo.repository.AssuntoRepository;
import javassist.NotFoundException;

@Service
public class AssuntoService {

	@Autowired
	AssuntoRepository assuntoRepository;

	public List<Assunto> getAll() throws NotFoundException {

		List<Assunto> list = assuntoRepository.findAll();
		
		if(list.isEmpty()) {
			throw new NotFoundException("Assunto nao encontrado");
		}
		return list;

	}

	public Assunto getById(Long id) throws NotFoundException {

		Optional<Assunto> assunto = assuntoRepository.findById(id);
		
		if(assunto.isEmpty()) {
			throw new NotFoundException("Assunto nao encontrado");
		}
		return assunto.get();
	}

	public String addAssunto(Assunto assunto) {

		assuntoRepository.save(assunto);
		return "Assunto criado com sucesso!";
	}

	public Assunto updateAssunto(Assunto assunto) {

		return assuntoRepository.save(assunto);
	}

	public String deleteAssunto(long id) {

		assuntoRepository.deleteById(id);
		return "Assunto removido com sucesso";
	}
}