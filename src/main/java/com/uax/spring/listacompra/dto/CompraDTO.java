package com.uax.spring.listacompra.dto;

public class CompraDTO {

	public int id;
	public String descripcion;

	public CategoriaDTO categoria;
	
	private static int counterByID = 1;
	
	
	public CompraDTO() {
		super();
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public static int getCounterByID() {
		return counterByID++;
	}


	public CategoriaDTO getCategoria() {
		return categoria;
	}


	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}


	public void setCategoria(Object object) {
		this.categoria = categoria;
		
	}

	
	

	
	
	
	
}
