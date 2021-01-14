package br.com.dsn.pack.karoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.dsn.pack.karoo.domain.Funcionario;
import br.com.dsn.pack.karoo.service.FuncionarioService;
import br.com.dsn.pack.karoo.service.JwtService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;

@RestController
@RequestMapping("/karoo")
@Api(value="Api REST Alterdata newKaroo")
@CrossOrigin(origins="*")
public class JwtController {
	
	@Autowired
	FuncionarioService funcionarioService;
	
	@Autowired
	JwtService jwtService;
	
	@PostMapping("/login")
	@ApiOperation(value="Cria um json web token com o email e a senha")
	public ResponseEntity<String> login(@RequestBody Funcionario funcionario) throws JsonProcessingException, NotFoundException {
		
		Funcionario funcFound = null;
		String token = "";
		List<Funcionario> listFunc = funcionarioService.getAll();
		
		if(funcionario == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não encontrado");
		
		for (Funcionario func : listFunc) {
			if(func.getEmail().equalsIgnoreCase(funcionario.getEmail()) && func.getSenha().equals(funcionario.getSenha())) {
				funcFound = func; 
				token = jwtService.generateToken(funcFound);
			} else {
				throw new NotFoundException("Funcionario nao encontrado");
			}
		}
		return ResponseEntity.ok(token);
	}
	
	@PostMapping("/login/verify")
	@ApiOperation(value="Decodifica e valida o json web token ")
	public ResponseEntity<Boolean> verifyLogin(@RequestBody String token) {
		return ResponseEntity.ok(jwtService.decodeToken(token));
	}
}
