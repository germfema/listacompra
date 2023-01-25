package com.uax.spring.listacompra.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uax.spring.listacompra.dto.CategoriaDTO;
import com.uax.spring.listacompra.dto.CompraDTO;
import com.uax.spring.listacompra.repositories.CategoriaRepository;
import com.uax.spring.listacompra.repositories.CompraRepository;

@Controller
public class WelcomeController implements ErrorController {

	@Autowired
	CompraRepository compraRepository;

	@Autowired
	CategoriaRepository categoriaRepository;

	@GetMapping("/index")
	public String goToIndex(Model model) {

		return "index";
	}

	@Cacheable(value = "compras")
	@GetMapping("/go-to-lista")
	public String goToLista(Model model) {

		List<CompraDTO> compras = compraRepository.getAllCompras();
		
		for (CompraDTO c : compras) {
			int idCategoria = c.getCategoria().getId();
			CategoriaDTO categoria = categoriaRepository.getCategoriaById(idCategoria);
			c.setCategoria(categoria);
		}
		model.addAttribute("productos", compras);

		return "pLista";
	}

	@GetMapping("/add-producto")
	public String goToFormProducto(Model model) {

		CompraDTO producto = new CompraDTO();
		CategoriaDTO cat = new CategoriaDTO();
//		producto.setCategoria(cat);

//		model.addAttribute("categoria",cat);
		model.addAttribute("producto", producto);

		model.addAttribute("categorias", categoriaRepository.getAllCategoria());

		return "pAddProducto";
	}

	@PostMapping("/add-producto")
	public String goProductoToList(@ModelAttribute("producto") CompraDTO producto) {

		CategoriaDTO categoria = categoriaRepository.getCategoriaById(producto.getCategoria().getId());
		producto.setCategoria(categoria);

		compraRepository.saveCompra(producto);

		return "redirect:/go-to-lista";
	}

	@GetMapping("/delete-producto")
	public String deleteProductoByID(@RequestParam("id") int id) {

		compraRepository.deleteCompra(id);

		return "redirect:/go-to-lista";
	}

	@GetMapping("/update-producto")
	public String updateProductoByID(@RequestParam("id") int id, Model model) {

		CompraDTO compra = new CompraDTO();

		model.addAttribute("producto", compra);

		return "pAddProducto";
	}

//	@ExceptionHandler(ViewNotFoundException.class)
//	public ModelAndView handleStudentNotFoundException(ViewNotFoundException ex) {
//		Map<String, ViewNotFoundException> model = new HashMap<String, ViewNotFoundException>();
//		model.put("exception", ex);
//		return new ModelAndView("404error", model);
//
//	}
//
	
	
	
	
	@RequestMapping("/error")
	public String showError404Generic(Exception ex) {

		return "404error";

	}
	
	
	
	
	
//
//	@ExceptionHandler(Exception.class)
//	public ModelAndView handleException(Exception ex) {
//		Map<String, Exception> model = new HashMap<String, Exception>();
//		model.put("exception", ex);
//		return new ModelAndView("student.error.500", model);
//
//	}

}
