package com.rodrigo.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rodrigo.bookstore.domain.Livro;
import com.rodrigo.bookstore.dtos.LivroDTO;
import com.rodrigo.bookstore.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService livroService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Long id) {
		Livro obj = this.livroService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(
			@RequestParam(value = "categoria", defaultValue = "0") Long categoriaId) {
		
		List<Livro> list = this.livroService.findAll(categoriaId);
		List<LivroDTO> listDTO = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<Livro> create(
			@RequestParam(value = "categoria", defaultValue = "0") Long categoriaId, 
			@RequestBody Livro obj) {
		Livro newObj = this.livroService.create(categoriaId, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<LivroDTO> update(@PathVariable Long id, @RequestBody Livro obj) {
		Livro newObj = this.livroService.update(id, obj);
		return ResponseEntity.ok().body(new LivroDTO(newObj));
	}

	@PatchMapping(value = "/{id}")
	public ResponseEntity<LivroDTO> updatePatch(@PathVariable Long id, @RequestBody Livro obj) {
		Livro newObj = this.livroService.update(id, obj);
		return ResponseEntity.ok().body(new LivroDTO(newObj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		this.livroService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
