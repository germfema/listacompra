package com.uax.spring.listacompra.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uax.spring.listacompra.dto.CompraDTO;
import com.uax.spring.listacompra.repositories.CompraRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/api")
@RestController
public class ComprasControllerRest {
	
	@Autowired
	CompraRepository compraRepository;
	
	@Cacheable(value = {"compras"})
	@ApiResponse(responseCode = "404",description = "No se ha encontrado la compra")
	@Operation(summary = "Obtiene todas las compras")
	@GetMapping("/compras")
	public List<CompraDTO> getAllCompras(){
		return compraRepository.getAllCompras();
	}
	
	@CacheEvict(value = "compras")
	@ApiResponse(responseCode = "400",description = "Alguno de los campos no es correcto")
	@Operation(summary = "Guarda una compra")
	@PostMapping("/compras")
	public boolean saveCompra(@RequestBody CompraDTO c) {
		
		
		compraRepository.saveCompra(c);
		return true;
	}
	
	@Operation(summary = "Modifica una compra")
	@PutMapping("/compras")
	public boolean updateCompra(@RequestBody CompraDTO c) {
		return compraRepository.updateCompra(c);
	}
	
	@Operation(summary = "Elimina una compra por su ID")
	@DeleteMapping("/compras/{id}")
	public boolean deleteCompra(@PathVariable("id") int id) {
		return compraRepository.deleteCompra(id);
	}
	
	@Operation(summary = "Obtiene una compra por su ID")
	@GetMapping("/compras/{id}")
	public CompraDTO getCompraById(@PathVariable("id") int id) {
		return compraRepository.getCompraByID(id);
	}
	
}
