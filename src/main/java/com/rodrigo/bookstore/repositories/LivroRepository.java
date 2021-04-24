package com.rodrigo.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rodrigo.bookstore.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :categoriaId ORDER BY titulo")
	List<Livro> findAllByCategoria(@Param(value = "categoriaId") Long categoriaId);

}
