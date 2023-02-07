package com.uax.spring.listacompra.repositories;

import java.util.List;

import com.uax.spring.listacompra.dto.CompraDTO;

public interface ICompraRepository {

	public boolean saveCompra(CompraDTO compra);
	public boolean updateCompra(CompraDTO compra);
	public List<CompraDTO> getAllCompras();
	public CompraDTO getCompraByID(int id);
	public boolean deleteCompra(int id);
	public boolean updateCompraEnabled(CompraDTO compra);
	public CompraDTO getCompraByDescription(String descripcion);
	
}
