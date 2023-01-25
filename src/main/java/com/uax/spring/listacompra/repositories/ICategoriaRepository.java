package com.uax.spring.listacompra.repositories;

import java.util.List;

import com.uax.spring.listacompra.dto.CategoriaDTO;

public interface ICategoriaRepository {
	public List<CategoriaDTO> getAllCategoria();
	public CategoriaDTO getCategoriaById(int id);
}
