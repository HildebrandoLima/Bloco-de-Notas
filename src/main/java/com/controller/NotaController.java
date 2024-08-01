package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Nota;
import com.service.impl.NotaService;

@RestController
@RequestMapping("nota")
public class NotaController {

	@Autowired
	private NotaService notaService;
	
	public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

	@GetMapping
	public ResponseEntity<Iterable<Nota>> buscarTodos() {
		return ResponseEntity.ok(notaService.searchAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Nota> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(notaService.searchByID(id));
	}

	@PostMapping
	public ResponseEntity<Nota> inserir(@RequestBody Nota nota) {
		notaService.create(nota);
		return ResponseEntity.ok(nota);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Nota> atualizar(@PathVariable Long id, @RequestBody Nota nota) {
		notaService.update(id, nota);
		return ResponseEntity.ok(nota);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		notaService.delete(id);
		return ResponseEntity.ok().build();
	}

}
