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
					"INSERT INTO Compras (descripcion,categoria) VALUES('%s','%d')",
										compra.getDescripcion(),compra.getCategoria().getId());
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
		
	return jdbctemplate.query("SELECT * FROM Compras", new CompraRowMapper());

	}

	@Override
	public CompraDTO getCompraByID(int id) {
		String sql = String.format("SELECT * FROM Compras where id='%d'",id);
		return jdbctemplate.queryForObject(sql, new CompraRowMapper());

	}

	@Override
	public boolean deleteCompra(int id) {
		String sql = String.format("DELETE FROM Compras where id='%d'",id);
		jdbctemplate.execute(sql);
		return true;
	}

}
