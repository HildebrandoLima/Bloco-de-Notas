package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Nota;

@Repository
public interface NotaRepository extends CrudRepository<Nota, Long> {
	List<Nota> findAllByTitulo(String titulo);
}
