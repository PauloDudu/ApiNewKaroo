package br.com.dsn.pack.karoo.exceptions;

public class FuncionarioNotValidException extends Exception {

	private static final long serialVersionUID = 1L;
	private final Long id;
	
	
	public FuncionarioNotValidException() {
		this.id = (long) 0;
	}

	public FuncionarioNotValidException(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

}
