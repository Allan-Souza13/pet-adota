package com.allan.pets.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String imagem;
	private String nome;
	private String especie;
	private Boolean adotado;
	
	
	public Pet() {
		
		
	}
	
	public String getImagem() {
		
		return imagem;
	}
	
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	
	
	
	public Pet(String nome, String especie, String imagem) {
		
		this.nome = nome;
		this.especie = especie;
		this.imagem = imagem;
		this.adotado = false;
		
	}
	
	public Long getId() {
		return id;
	}

	
	public String getNome() {
	
	return nome;
	 	}
	
	public String getEspecie() {
		
		return especie;
	}
	
	
	public Boolean getAdotado() {
		return adotado;
	}

	public void setNome(String nome) {
		
		this.nome = nome;
		
	}
	
	public void setEspecie(String especie) {
		
		this.especie = especie;
		
	}

	public void setAdotado(Boolean adotado) {
	
		this.adotado = adotado;
	
}
		
	}
	
	
	
	
	
	
	
	
	
	
	

