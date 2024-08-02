package com.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Nota;
import com.repository.NotaRepository;
import com.service.exception.HttpConflict;
import com.service.exception.HttpNotFound;
import com.service.exception.HttpOk;

@Service
public class NotaImplService implements NotaService {

	@Autowired
	private NotaRepository notaRepository;

	public NotaImplService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

	@Override
	public Iterable<Nota> searchAll() {
		Iterable<Nota> notas = notaRepository.findAll();
		Nota[] data = listToArray(notas);
		throw new HttpOk(data);
	}

	@Override
	public Nota searchByID(Long id) {
		Optional<Nota> nota = thereIsNoteById(id);
		if (nota.isEmpty()) {
			throw new HttpNotFound();
		}
		throw new HttpOk(new Nota[]{nota.get()});
	}

	@Override
	public void create(Nota nota) {
		if (!thereIsNoteByTitle(nota.getTitulo()).isEmpty()) {
			throw new HttpConflict();
		}
		notaRepository.save(nota);
		throw new HttpOk(null);
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
		throw new HttpOk(null);
	}

	@Override
	public void delete(Long id) {
		notaRepository.deleteById(id);
		throw new HttpOk(null);
	}

	private Nota[] listToArray(Iterable<Nota> notas) {
		Nota[] data = StreamSupport
		.stream(notas.spliterator(), false)
        .toArray(Nota[]::new);
		return data;
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
