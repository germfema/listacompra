package com.uax.spring.listacompra.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.uax.spring.listacompra.dto.CategoriaDTO;
import com.uax.spring.listacompra.dto.CompraDTO;
import com.uax.spring.listacompra.dto.UsuarioDTO;
import com.uax.spring.listacompra.repositories.CategoriaRepository;

@Component
public class UsuarioRowMapper implements RowMapper<UsuarioDTO>{

	@Override
	public UsuarioDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		UsuarioDTO u = new UsuarioDTO();
		u.setUserName(rs.getString(1));
		u.setPassword(rs.getString(2));
		u.setRoles(rs.getString(3));
		return u;
	}

}
