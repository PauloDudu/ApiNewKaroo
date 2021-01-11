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

import br.com.dsn.pack.karoo.domain.Funcionario;
import br.com.dsn.pack.karoo.exceptions.FuncionarioNotFoundException;
import br.com.dsn.pack.karoo.service.FuncionarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/karoo")
@Api(value="Api REST Alterdata newKaroo")
@CrossOrigin(origins="*")
public class FuncionarioController {
	
	@Autowired
	FuncionarioService funcionarioService;
	
	@GetMapping("/funcionarios")
	@ApiOperation(value="Retorna uma lista de funcionarios")
	public ResponseEntity<List<Funcionario>> listFunc() throws FuncionarioNotFoundException {
		return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.getAll());
	}
	
	@GetMapping("/funcionarios/{id}")
	@ApiOperation(value="Retorna um funcionario pelo id passado na rota")
	public ResponseEntity<Funcionario> getFuncById(@PathVariable(value="id") long id) {
		return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.getById(id));
	}
	
	@PostMapping("/funcionarios")
	@ApiOperation(value="Adiciona um funcionario a lista")
	public ResponseEntity<Funcionario> createFunc(@RequestBody Funcionario funcionario) {
		return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.addFuncionario(funcionario)); 
	}
	
	
	@DeleteMapping("/funcionarios/{id}")
	@ApiOperation(value="Deleta um funcionario da lista")
	public void deleteFunc(@PathVariable(value="id") long id) {
		funcionarioService.deleteFuncionario(id);
	}
	
	@PutMapping("/funcionarios")
	@ApiOperation(value="Atualiza um funcionario")
	public ResponseEntity<Funcionario> updateFunc(@RequestBody Funcionario funcionario) {
		return ResponseEntity.ok(funcionarioService.updateFuncionario(funcionario));
	}
}