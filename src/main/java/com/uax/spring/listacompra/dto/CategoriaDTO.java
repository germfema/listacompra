package com.uax.spring.listacompra.dto;

public class CategoriaDTO {

	public int id;
	public String categoria;
	
	public CategoriaDTO(int id, String categoria) {
		super();
		this.id = id;
		this.categoria = categoria;
	}
	public CategoriaDTO() {
		super();
	}
	
	
	
	
	public CategoriaDTO(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
}
