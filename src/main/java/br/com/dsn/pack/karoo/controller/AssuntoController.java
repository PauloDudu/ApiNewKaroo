package br.com.dsn.pack.karoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dsn.pack.karoo.domain.Assunto;
import br.com.dsn.pack.karoo.exceptions.AssuntoNotFoundException;
import br.com.dsn.pack.karoo.exceptions.AssuntoNotValidException;
import br.com.dsn.pack.karoo.service.AssuntoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/karoo")
@Api(value="Api REST Alterdata newKaroo")
@CrossOrigin(origins="*")
public class AssuntoController {
	
	@Autowired
	AssuntoService assuntoService;
	
	@GetMapping("/assuntos")
	@ApiOperation(value="Retorna uma lista de assuntos")
	public ResponseEntity<List<Assunto>> listUsers() throws AssuntoNotFoundException {
		return ResponseEntity.status(HttpStatus.OK).body(assuntoService.getAll());
	}
	
	@GetMapping("/assuntos/{id}")
	@ApiOperation(value="Retorna um assunto pelo id passado na rota")
	public ResponseEntity<Assunto> getById(@PathVariable(value="id") long id) throws AssuntoNotFoundException {
		return ResponseEntity.status(HttpStatus.OK).body(assuntoService.getById(id));
	}
	
	@PostMapping("/assuntos")
	@ApiOperation(value="Adiciona um assunto a lista")
	public ResponseEntity<String> createUser(@RequestBody Assunto assunto) throws AssuntoNotValidException {
		return ResponseEntity.status(HttpStatus.OK).body(assuntoService.addAssunto(assunto)); 
	}
	
	@DeleteMapping("/assunto/{id}")
	@ApiOperation(value="Deleta um assunto da lista")
	public void deleteUser(@PathVariable(value="id") long id) throws AssuntoNotFoundException {
		assuntoService.deleteAssunto(id);
	}
	
	@PutMapping("/assunto")
	@ApiOperation(value="Atualiza um assunto")
	public ResponseEntity<Assunto> updateUser(@RequestBody Assunto assunto) throws AssuntoNotValidException {
		return ResponseEntity.ok(assuntoService.updateAssunto(assunto));
	}
}