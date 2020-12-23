package br.com.dsn.pack.karoo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.dsn.pack.karoo.exceptions.DestaqueNotFoundException;
import br.com.dsn.pack.karoo.exceptions.DestaqueNotValidException;
import br.com.dsn.pack.karoo.exceptions.FuncionarioNotFoundException;
import br.com.dsn.pack.karoo.exceptions.FuncionarioNotValidException;

@RestControllerAdvice
public class ExceptionController {
	
	private static final String K_KAROOERRO_CODE = "k-karooerro-code";
	private static final String K_KAROOERRO_MSG = "k-karooerro-msg";
	private static final String K_KAROOERRO_VALUE = "k-karooerro-value";

	@ExceptionHandler(DestaqueNotFoundException.class)
	public ResponseEntity<String> tratarDestaqueNotFound(DestaqueNotFoundException exception) {
		String msg = "Destaque nao encontrado!";

		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.header(K_KAROOERRO_MSG, msg)
				.header(K_KAROOERRO_CODE, "DEST_NOT_FOUND")
				.header(K_KAROOERRO_VALUE, exception.getId().toString())
				.body(msg);
	}
	
	@ExceptionHandler(DestaqueNotValidException.class)
	public ResponseEntity<String> tratarDestaqueNotFound(DestaqueNotValidException exception) {
		String msg = "Destaque nao encontrado!";

		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.header(K_KAROOERRO_MSG, msg)
				.header(K_KAROOERRO_CODE, "DEST_NOT_VALID")
				.header(K_KAROOERRO_VALUE, exception.getId().toString())
				.body(msg);

	}
	
	@ExceptionHandler(FuncionarioNotFoundException.class)
	public ResponseEntity<String> tratarFuncionarioNotFound(FuncionarioNotFoundException exception) {
		String msg = "Funcionario nao encontrado!";

		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.header(K_KAROOERRO_MSG, msg)
				.header(K_KAROOERRO_CODE, "FUNC_NOT_FOUND")
				.header(K_KAROOERRO_VALUE, exception.getId().toString())
				.body(msg);
	}
	
	@ExceptionHandler(FuncionarioNotValidException.class)
	public ResponseEntity<String> tratarFuncionarioNotFound(FuncionarioNotValidException exception) {
		String msg = "Funcionario nao encontrado!";

		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.header(K_KAROOERRO_MSG, msg)
				.header(K_KAROOERRO_CODE, "FUNC_NOT_VALID")
				.header(K_KAROOERRO_VALUE, exception.getId().toString())
				.body(msg);

	}
}
