package com.uax.spring.listacompra.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uax.spring.listacompra.dto.RecetaDTO;
import com.uax.spring.listacompra.services.CompraService;
import com.uax.spring.listacompra.services.RecetasServices;

@Controller
public class RecetasController {

	@Autowired
	RecetasServices recetaService;
	
	@Autowired
	CompraService compraService;
	
	@GetMapping("/go-to-Recetas")
	public String goToPageListRecetas(Model modelo) {
		
		ArrayList<RecetaDTO> recetas = recetaService.getListRecetasRandom();
		modelo.addAttribute("recetas", recetas);
		
		return "recetas/pListaRecetas";
	}
	
	@GetMapping("/add-ingredients")
	public String addIngredientsByIdMeal(@RequestParam("idMeal") int idMeal) {
		
		RecetaDTO receta = recetaService.getIngredientsByIdMeal(idMeal);
		
		compraService.insertIngredientByApiMeal(receta);
		
		return "redirect:/go-to-lista";
	}
	
}
