package br.com.dsn.pack.karoo.exceptions;

public class FuncionarioNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private final Long id;
	
	public FuncionarioNotFoundException() {
		this.id = (long) 0;
	}

	public FuncionarioNotFoundException(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
