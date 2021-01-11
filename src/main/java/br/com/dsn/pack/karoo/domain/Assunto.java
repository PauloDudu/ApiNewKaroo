package br.com.dsn.pack.karoo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="assunto")
public class Assunto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;	
	
	private String codigoCliente;
	
	private String email;
	
	private String nomeCliente;
	
	private String conteudo;
	
	private boolean atendido;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	public boolean isAtendido() {
		return atendido;
	}

	public void setAtendido(boolean atendido) {
		this.atendido = atendido;
	}

	public boolean ehvalido() {
		boolean ehValido = false;
		
		if((this.codigoCliente.isEmpty() || this.email.isEmpty() || this.nomeCliente.isEmpty() || !this.conteudo.isEmpty()) || !this.atendido) {
			ehValido = true;
		}
		
		return ehValido;
	}

}