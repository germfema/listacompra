package com.uax.spring.listacompra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.uax.spring.listacompra.dto.CompraDTO;
import com.uax.spring.listacompra.dto.UsuarioDTO;
import com.uax.spring.listacompra.services.UserService;

@Controller
public class UserWebController {

	@Autowired
	UserService userService;
	
	@GetMapping("/pantallaRegistro")
	public String irPantallaRegistro(Model model) {
		
		return "security/registration";
	}
	
	@PostMapping("/pantallaRegistro")
	public String registrarUsuarioWeb(@ModelAttribute("usuario") UsuarioDTO usuario) {
		
		usuario.setRoles("USER");
		userService.registerUserDB(usuario);
		
		return "login";
	}
}
