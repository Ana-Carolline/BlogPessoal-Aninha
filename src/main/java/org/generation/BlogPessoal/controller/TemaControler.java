package org.generation.BlogPessoal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.generation.BlogPessoal.model.tema;
import org.generation.BlogPessoal.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/temas")
@CrossOrigin ("*")
public class TemaControler {
	
	@Autowired
	private TemaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<tema>> getAll(){
		List<tema> objetoLista = repository.findAll();
		
		if (objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(objetoLista);
	
		}
	}	
		
	@GetMapping("/tema/{tema}")
	public ResponseEntity<List<tema>> findByTema(@PathVariable(value = "tema")String Tema){
		List<tema> objetoLista = repository.findAllByTemaContainingIgnoreCase(Tema);
		
		if (objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		}
		else {
			return ResponseEntity.status(200).body(objetoLista);
		}
		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<tema> findById(@PathVariable(value = "id") Long idTema) {
		Optional<tema> objetoTema = repository.findById(idTema);

		if (objetoTema.isPresent()) {
			return ResponseEntity.status(200).body(objetoTema.get());
		} else {
			return ResponseEntity.status(204).build();
		}
	}

	@PostMapping("/novotema")
	public ResponseEntity<tema> PostTema(@Valid @RequestBody tema novoTema) {
		return ResponseEntity.status(201).body(repository.save(novoTema));
	}
	
	@PutMapping("/atualizatema")
	public ResponseEntity<tema> PutTema(@Valid @RequestBody tema temaParaAtualizar) {
		return ResponseEntity.status(201).body(repository.save(temaParaAtualizar));
	}
	@DeleteMapping("/deletar/{id_tema}")
	public void DeleteById(@PathVariable(value = "id_tema") Long idTema) {
		repository.deleteById(idTema);
	}
}
