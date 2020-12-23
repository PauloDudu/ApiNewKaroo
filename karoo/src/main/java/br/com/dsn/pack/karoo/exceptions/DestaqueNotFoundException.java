package br.com.dsn.pack.karoo.exceptions;

public class DestaqueNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private final Long id;
	
	public DestaqueNotFoundException() {
		this.id = (long) 0;
	}

	public DestaqueNotFoundException(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	
}