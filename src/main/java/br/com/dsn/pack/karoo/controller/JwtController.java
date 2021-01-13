package br.com.dsn.pack.karoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dsn.pack.karoo.domain.Funcionario;
import br.com.dsn.pack.karoo.service.FuncionarioService;
import br.com.dsn.pack.karoo.service.JwtService;
import io.swagger.annotations.Api;

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
	public ResponseEntity<String> login(@RequestBody Funcionario funcionario) {

		String token = jwtService.generateToken(funcionario);
		
		return ResponseEntity.ok(token);
	}
}