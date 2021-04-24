package com.rodrigo.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.bookstore.domain.Categoria;
import com.rodrigo.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj = this.categoriaRepository.findById(id);
		
		return obj.orElse(null);
	}

}
