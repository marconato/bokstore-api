package com.rodrigo.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.rodrigo.bookstore.domain.Livro;
import com.rodrigo.bookstore.dtos.LivroDTO;
import com.rodrigo.bookstore.repositories.LivroRepository;
import com.rodrigo.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Long id) {
		Optional<Livro> obj = this.livroRepository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}
	
	public List<Livro> findAll(Long categoriaId) {
		this.categoriaService.findById(categoriaId);
		return livroRepository.findAllByCategoria(categoriaId);
	}

	public Livro create(Livro obj) {
		obj.setId(null);
		return this.livroRepository.save(obj);
	}

	public Livro update(Long id, LivroDTO objDto) {
		Livro obj = findById(id);
		obj.setNome_autor(objDto.getNome_autor());
		obj.setTitulo(objDto.getTitulo());

		return this.livroRepository.save(obj);
	}

	public void delete(Long id) {
		this.findById(id);
		try {
			this.livroRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.rodrigo.bookstore.service.exceptions.DataIntegrityViolationException(
					"Livro não pode ser deletado! Possui livros associados");
		}

	}

}
