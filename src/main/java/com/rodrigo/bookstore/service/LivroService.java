package com.rodrigo.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.bookstore.domain.Livro;
import com.rodrigo.bookstore.repositories.LivroRepository;
import com.rodrigo.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;

	public Livro findById(Long id) {
		Optional<Livro> obj = this.livroRepository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}

}
