package com.uax.spring.listacompra.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MyErrorsController implements ErrorController {

	@GetMapping("/error")
	public String showPageError404(Exception e,HttpServletResponse req,Model m) {
		
		String vista ="";
		
		switch (req.getStatus()) {
		case HttpServletResponse.SC_NOT_FOUND: {
			m.addAttribute("mensaje.error", e.getMessage());
			
			vista = "error/404error";
		}
		case HttpServletResponse.SC_INTERNAL_SERVER_ERROR:{
			vista = "/error/500error";
			return vista;
		}
		default:
			vista = "/error/404error";
		}
		
		return vista;
	}

//
//	@ExceptionHandler(Exception.class)
//	public ModelAndView handleException(Exception ex) {
//		Map<String, Exception> model = new HashMap<String, Exception>();
//		model.put("exception", ex);
//		return new ModelAndView("ExceptionPage", model);
//
//	}
}
