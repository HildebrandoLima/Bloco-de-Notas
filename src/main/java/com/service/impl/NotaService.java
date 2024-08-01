package com.service.impl;

import com.model.Nota;

public interface NotaService {

	Iterable<Nota> searchAll();

	Nota searchByID(Long id);

	void create(Nota nota);

	void update(Long id, Nota nota);

	void delete(Long id);

}
