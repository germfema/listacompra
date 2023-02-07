package com.uax.spring.listacompra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;


/**
 * @author German
 *
 */
@EnableCaching
@SpringBootApplication()
public class ListacompraApplication  {

	
	public static void main(String[] args) {
		SpringApplication.run(ListacompraApplication.class, args);
	}

}
