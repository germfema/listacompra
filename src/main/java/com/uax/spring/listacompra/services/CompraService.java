package com.uax.spring.listacompra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uax.spring.listacompra.dto.CategoriaDTO;
import com.uax.spring.listacompra.dto.CompraDTO;
import com.uax.spring.listacompra.dto.RecetaDTO;
import com.uax.spring.listacompra.repositories.CompraRepository;

@Service
public class CompraService {

	public static String uriImagenIngrediente = "https://www.themealdb.com/images/ingredients/%s-Small.png";
	
	@Autowired
	public CompraRepository compraRepo;
	
	public boolean insertIngredientByApiMeal(RecetaDTO receta) {
		
		for (String ingrediente : receta.getIngredients()) {
			
			String urlImagen = String.format(uriImagenIngrediente, ingrediente);
			CategoriaDTO cat = new CategoriaDTO(1,"Frutas");
			
			CompraDTO compra = new CompraDTO(ingrediente,cat,urlImagen);
			
			if(getCompraByDescripcion(ingrediente)) {
				compraRepo.updateCompraEnabled(compra);
			}else {
				compraRepo.saveCompra(compra);
			}
		}
		
		return true;
	}
	
	public boolean getCompraByDescripcion(String descripcion) {
		
		CompraDTO compra = compraRepo.getCompraByDescription(descripcion);
		
		if(compra == null) {
			return false;
		}
		
		return true;
	}
	
}
