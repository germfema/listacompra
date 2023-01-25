package com.uax.spring.listacompra.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.uax.spring.listacompra.dto.CategoriaDTO;

public class CategoriaRowMapper implements RowMapper<CategoriaDTO>{

	@Override
	public CategoriaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CategoriaDTO cat = new CategoriaDTO();
		cat.setId(rs.getInt(1));
		cat.setCategoria(rs.getString(2));
		
		return cat;
	}

}
