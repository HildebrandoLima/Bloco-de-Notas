package com.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Nota;
import com.repository.NotaRepository;
import com.service.exception.HttpConflict;
import com.service.exception.HttpNotFound;

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
		Optional<Nota> nota = thereIsNoteById(id);
		if (nota.isEmpty()) {
			throw new HttpNotFound();
		}
		return nota.get();
	}

	@Override
	public void create(Nota nota) {
		if (!thereIsNoteByTitle(nota.getTitulo()).isEmpty()) {
			throw new HttpConflict();
		}
		notaRepository.save(nota);
	}

	@Override
	public void update(Long id, Nota nota) {
		if (thereIsNoteById(id).isEmpty()) {
			throw new HttpNotFound();
		}
		if (!thereIsNoteByTitle(nota.getTitulo()).isEmpty()) {
			throw new HttpConflict();
		}
		notaRepository.save(nota);
	}

	@Override
	public void delete(Long id) {
		notaRepository.deleteById(id);
	}

	private Optional<Nota> thereIsNoteById(Long id) {
		Optional<Nota> exist = notaRepository.findById(id);
		return exist;
	}

	private List<Nota> thereIsNoteByTitle(String title) {
		List<Nota> exist = notaRepository.findAllByTitulo(title);
		return exist;
	}

}
