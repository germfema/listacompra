package com.uax.spring.listacompra.dto;

public class CompraDTO {

	public int id;
	public String descripcion;
	public CategoriaDTO categoria;
	public String imagenUrl;
	public boolean enabled;

	public CompraDTO() {
		super();
	}

	public CompraDTO(String descripcion, CategoriaDTO cat, String imagenUrl) {
		super();
		this.descripcion = descripcion;
		this.categoria = cat;
		this.imagenUrl = imagenUrl;
	}
	
	
	public CompraDTO(int id, String descripcion, CategoriaDTO categoria, String imagenUrl, boolean enabled) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.imagenUrl = imagenUrl;
		this.enabled = enabled;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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
