package com.uax.spring.listacompra.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.uax.spring.listacompra.dto.UsuarioDTO;
import com.uax.spring.listacompra.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
    	UserDetails user;
    	
    	try {
        	
    	final UsuarioDTO customer = userRepository.findByUsername(username);
        
    	   user = User.withUsername(customer.getUserName()).password(customer.getPassword()).authorities("USER").build();
        
//    	   user = User.withUsername(username)
//                   .roles(customer.getRoles())
//                   .password(customer.getPassword())
//                   .build();
    	
    	
    	} catch (EmptyResultDataAccessException e) {
    		return null;
    	}
         
      
        return user;
    }

}