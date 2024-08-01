package com.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Nota;
import com.repository.NotaRepository;

@Service
public class NotaImplService implements NotaService {

	@Autowired
	private NotaRepository notaRepository;

	public NotaImplService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

	@Override
	public Iterable<Nota> searchAll() {
		return notaRepository.findAll();
	}

	@Override
	public Nota searchByID(Long id) {
		Optional<Nota> nota = notaRepository.findById(id);
		if (nota.isEmpty()) {
			//
		}
		return nota.get();
	}

	@Override
	public void create(Nota nota) {
		notaRepository.save(nota);
	}

	@Override
	public void update(Long id, Nota nota) {
		Optional<Nota> exist = notaRepository.findById(id);
		if (exist.isEmpty()) {
			//
		}
		notaRepository.save(nota);
	}

	@Override
	public void delete(Long id) {
		notaRepository.deleteById(id);
	}

}
