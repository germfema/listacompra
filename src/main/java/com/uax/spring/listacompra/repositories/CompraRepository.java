package com.uax.spring.listacompra.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uax.spring.listacompra.dto.CompraDTO;
import com.uax.spring.listacompra.mappers.CompraRowMapper;

@Repository
public class CompraRepository implements ICompraRepository {

	@Autowired
	@Qualifier("jdbcTemplateDB1")
	private JdbcTemplate jdbctemplate;

	@Autowired
	@Qualifier("jdbcTemplateDB2")
	private JdbcTemplate jdbctemplateDB2;

	@Override
	public boolean saveCompra(CompraDTO compra) {

		try {

			String sql = String.format(
					"INSERT INTO Compras (descripcion,categoria,imagenUrl, enabled) VALUES('%s','%d','%s',1)",
										compra.getDescripcion(),compra.getCategoria().getId(),compra.getImagenUrl());
			jdbctemplate.execute(sql);
		
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public CompraDTO getCompraByDescription(String descripcion) {
	
		String sql = String.format("SELECT c.id,c.descripcion,c.categoria,cat.nombre,c.imagenUrl FROM Compras c,categorias cat where c.categoria=cat.id where descripcion='%s'",descripcion);
		return jdbctemplate.queryForObject(sql, new CompraRowMapper());
	}

	
	public boolean updateCompraEnabled(CompraDTO compra) {

		try {

			String sql = String.format(
					"UPDATE Compras SET enabled=1 WHERE id = %d",
										compra.getId());
			jdbctemplate.execute(sql);

		} catch (Exception e) {
			return false;
		}

		return true;
	}
	
	
	@Override
	public boolean updateCompra(CompraDTO compra) {
		String sql = String.format("UPDATE Compras SET descripcion='%s' where id='%d'",compra.getDescripcion(),compra.getId());
		jdbctemplate.execute(sql);
		return true;
	}

	@Override
	public List<CompraDTO> getAllCompras() {
		
	return jdbctemplate.query("SELECT c.id,c.descripcion,c.categoria,cat.nombre,c.imagenUrl FROM compras c, categorias cat where c.categoria=cat.id and enabled=1", new CompraRowMapper());

	}

	@Override
	public CompraDTO getCompraByID(int id) {
		String sql = String.format("SELECT * FROM Compras where id='%d'",id);
		return jdbctemplate.queryForObject(sql, new CompraRowMapper());

	}

	@Override
	public boolean deleteCompra(int id) {
		String sql = String.format("UPDATE Compras SET enabled=0 where id='%d'",id);
		jdbctemplate.execute(sql);
		return true;
	}

}
