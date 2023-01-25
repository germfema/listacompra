package com.uax.spring.listacompra.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.uax.spring.listacompra.dto.CategoriaDTO;
import com.uax.spring.listacompra.dto.CompraDTO;
import com.uax.spring.listacompra.repositories.CategoriaRepository;

@Component
public class CompraRowMapper implements RowMapper<CompraDTO>{

	@Override
	public CompraDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CompraDTO compra = new CompraDTO();
		compra.setId(rs.getInt(1));
		compra.setDescripcion(rs.getString(2));
		compra.setCategoria(new CategoriaDTO(rs.getInt(3)));
		return compra;
	}

}
