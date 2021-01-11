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

import br.com.dsn.pack.karoo.domain.Destaque;
import br.com.dsn.pack.karoo.exceptions.DestaqueNotFoundException;
import br.com.dsn.pack.karoo.service.DestaqueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/karoo")
@Api(value="Api REST Alterdata newKaroo")
@CrossOrigin(origins="*")
public class DestaqueController {
	
	@Autowired
	DestaqueService destaqueService;
	
	@GetMapping("/destaques")
	@ApiOperation(value="Retorna uma lista de destaques")
	public ResponseEntity<List<Destaque>> listDestaques() throws DestaqueNotFoundException {
		return ResponseEntity.status(HttpStatus.OK).body(destaqueService.getAll());
	}
	
	@GetMapping("/destaques/{id}")
	@ApiOperation(value="Retorna um destaque pelo id passado na rota")
	public ResponseEntity<Destaque> getById(@PathVariable(value="id") long id)	{
		return ResponseEntity.status(HttpStatus.OK).body(destaqueService.getById(id));
	}
	
	@PostMapping("/destaques")
	@ApiOperation(value="Adiciona um destaque a lista")
	public ResponseEntity<?> createDestaque(@RequestBody Destaque destaque)	{
		return ResponseEntity.status(HttpStatus.OK).body(destaqueService.addDestaque(destaque)); 
	}
	
	@DeleteMapping("/destaques/{id}")
	@ApiOperation(value="Deleta um destaque da lista")
	public void deleteDestaque(@PathVariable(value="id") long id)	{
		destaqueService.deleteDestaque(id);
	}
	
	@PutMapping("/destaques")
	@ApiOperation(value="Atualiza um destaque")
	public ResponseEntity<Destaque> updateDestaque(@RequestBody Destaque destaque)	{
		return ResponseEntity.ok(destaqueService.updateDestaque(destaque));
	}
}