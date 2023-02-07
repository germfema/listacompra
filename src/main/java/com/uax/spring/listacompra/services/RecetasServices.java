package com.uax.spring.listacompra.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.uax.spring.listacompra.dto.CompraDTO;
import com.uax.spring.listacompra.dto.RecetaDTO;
import com.uax.spring.listacompra.dto.RecetaResponseDTO;

/**
 * @author German
 *
 */
@Service
public class RecetasServices {

	private final String uriMealApiRandom = "https://www.themealdb.com/api/json/v1/1/random.php";
	private final String uriMealApiByIdMeal= "https://www.themealdb.com/api/json/v1/1/lookup.php?i=";
	
	RestTemplate restT;
	Gson gson;
	
	public  RecetaDTO getRecetaRandomFromApi() {

		 restT = new RestTemplate();
		String result = restT.getForObject(uriMealApiRandom, String.class);

		return getResponseByString(result).getMeals().get(0);
	}

	public ArrayList<RecetaDTO> getListRecetasRandom() {

		ArrayList<RecetaDTO> recetas = new ArrayList<RecetaDTO>();

		for (int i = 0; i < 5; i++) {
			recetas.add(getRecetaRandomFromApi());
		}

		return recetas;
	}
	

	public RecetaDTO getIngredientsByIdMeal(int idMeal) {
		
		RestTemplate restT = new RestTemplate();
		String result = restT.getForObject(uriMealApiByIdMeal+idMeal, String.class);
	
		RecetaResponseDTO receta = getResponseByString(result);
		
		return receta.getMeals().get(0);
	}
	
	
	public RecetaResponseDTO getResponseByString(String result) {
		
		gson = new Gson();
		RecetaResponseDTO recetas = gson.fromJson(result, RecetaResponseDTO.class);
		
		return recetas;
	}
	

}
