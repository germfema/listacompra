package com.uax.spring.listacompra.repositories;

import com.uax.spring.listacompra.dto.UsuarioDTO;


public interface UserRepository {
   
    public UsuarioDTO findByUsername(String username);
     
}