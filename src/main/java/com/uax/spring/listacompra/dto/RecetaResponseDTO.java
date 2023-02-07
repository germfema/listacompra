package com.uax.spring.listacompra.dto;

import java.util.ArrayList;

public class RecetaResponseDTO {
	
	public ArrayList<RecetaDTO> meals;

	public ArrayList<RecetaDTO> getMeals() {
		return meals;
	}

	public void setMeals(ArrayList<RecetaDTO> meals) {
		this.meals = meals;
	}

}
