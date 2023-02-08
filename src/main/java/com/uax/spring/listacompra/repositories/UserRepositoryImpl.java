package com.uax.spring.listacompra.repositories;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.uax.spring.listacompra.dto.UsuarioDTO;
import com.uax.spring.listacompra.mappers.CompraRowMapper;
import com.uax.spring.listacompra.mappers.UsuarioRowMapper;

@Repository
public class UserRepositoryImpl implements UserRepository {

	static Logger log = Logger.getLogger(UserRepositoryImpl.class.getName());
	
	@Autowired
	@Qualifier("jdbcTemplateDB1")
	JdbcTemplate jdbctemplate;
	
	@Override
	public UsuarioDTO findByUsername(String username) {
		String sql = String.format(""
				+ "SELECT u.username, u.password, a.authority "
				+ "from users u, authorities a "
				+ "where u.username=a.username "
				+ "and u.username='%s'",username);
		
		return jdbctemplate.queryForObject(sql,new UsuarioRowMapper());
	}

}
