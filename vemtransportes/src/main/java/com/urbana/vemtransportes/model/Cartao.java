package com.urbana.vemtransportes.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_cartao")
public class Cartao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Torna o atribulo id em uma primery key dentro do banco de //												// dados;
	private Long id;

	@NotNull // Este campo não poderá estar vazio;
	private Long numeroCartao;

	@NotNull
	@Size(min = 5, max = 100) // Define o tamanho minímo e máximo do atributo nome;
	private String nome;//AQUI TALVEZ SEJA TIPO DE CARTAO

	private boolean status = true;

	@ManyToOne
	@JsonIgnoreProperties("cartao")
	private Usuario usuario;
	
	

	public Cartao(Long id, @NotNull Long numeroCartao, @NotNull @Size(min = 5, max = 100) String nome, boolean status,
			Usuario usuario) {
		super();
		this.id = id;
		this.numeroCartao = numeroCartao;
		this.nome = nome;
		this.status = status;
		this.usuario = usuario;
	}

	public Cartao() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(Long numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
