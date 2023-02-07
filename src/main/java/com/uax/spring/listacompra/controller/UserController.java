package com.uax.spring.listacompra.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uax.spring.listacompra.dto.UsuarioDTO;

@RestController
public class UserController {

	@Autowired
	private JdbcUserDetailsManager jdbcUserDetailsManager;

	@Autowired    
	private BCryptPasswordEncoder bCryptPasswordEncoder;


	@PostMapping(value = "/registrarUsuario")
	public ResponseEntity<String> register(@RequestBody UsuarioDTO myUser) {
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(myUser.getRoles()));
		
		
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//		Authentication authentication = new UsernamePasswordAuthenticationToken(myUser.getUserName(), myUser.getPassword(), authorities);
//		SecurityContextHolder.getContext().setAuthentication(authentication);
		
//		
		String encodededPassword = bCryptPasswordEncoder.encode(myUser.getPassword());
		
		User user = new User(myUser.getUserName(), encodededPassword, authorities);
		
		jdbcUserDetailsManager.createUser(user);
		
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}


}
