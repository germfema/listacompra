package com.uax.spring.listacompra.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uax.spring.listacompra.dto.User;


@RestController
public class UsuarioController {

	 @GetMapping("/welcome") public String welcome()
	    {
	        return "welcome.html";
	    }
	 
	    @GetMapping("/admin") public String user()
	    {
	        return "admin.html";
	    }
	 
	    @GetMapping("/basic") public String basic()
	    {
	        return "basic.html";
	    }
	 
	    @GetMapping("/login") public String login()
	    {
	        return "login.html";
	    }

}
