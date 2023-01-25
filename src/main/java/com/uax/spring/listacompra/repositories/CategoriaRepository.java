package com.uax.spring.listacompra.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uax.spring.listacompra.dto.CategoriaDTO;
import com.uax.spring.listacompra.mappers.CategoriaRowMapper;

@Repository
public class CategoriaRepository implements ICategoriaRepository{

	@Autowired
	@Qualifier("jdbcTemplateDB1")
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<CategoriaDTO> getAllCategoria() {
		
		
		return jdbcTemplate.query("SELECT * from Categorias", new CategoriaRowMapper());
	}

	@Override
	public CategoriaDTO getCategoriaById(int id) {
		String sql = String.format("SELECT * FROM Categorias WHERE id='%d'",id);
		return jdbcTemplate.queryForObject(sql, new CategoriaRowMapper());
	}

}
