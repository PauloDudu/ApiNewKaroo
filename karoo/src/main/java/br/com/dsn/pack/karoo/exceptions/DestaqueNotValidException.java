package br.com.dsn.pack.karoo.exceptions;

public class DestaqueNotValidException extends Exception {

	private static final long serialVersionUID = 1L;
	private final Long id;
	
	
	public DestaqueNotValidException() {
		this.id = (long) 0;
	}

	public DestaqueNotValidException(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
