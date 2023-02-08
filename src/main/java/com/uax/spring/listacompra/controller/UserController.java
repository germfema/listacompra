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
import com.uax.spring.listacompra.services.UserService;

@RestController
public class UserController {


	@Autowired
	private UserService userService;

	@PostMapping(value = "/registrarUsuario")
	public ResponseEntity<String> register(@RequestBody UsuarioDTO myUser) {
		
		userService.registerUserDB(myUser);
		
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}


}
