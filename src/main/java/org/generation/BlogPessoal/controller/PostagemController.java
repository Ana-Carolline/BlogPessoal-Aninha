package org.generation.BlogPessoal.controller;

import java.util.List;

import javax.validation.Valid;

import org.generation.BlogPessoal.model.postagem;
import org.generation.BlogPessoal.repository.PostagemRepository;
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
@RequestMapping ("/postagens")
@CrossOrigin ("*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<postagem>> FindAll(){
		List<postagem> objetoLista = repository.findAll();

		if (objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(objetoLista);
		}
	}
	
	@GetMapping ("/id/{id}")
	public ResponseEntity <postagem> GetByid (@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		
		}
	
	@GetMapping ("/titulo/{titulo}")
	public ResponseEntity<List<postagem>> buscarPorTituloI(@PathVariable(value = "titulo") String titulo) {
		List<postagem> objetoLista = repository.findAllByTituloContainingIgnoreCase(titulo);

		if (objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(objetoLista);
		}
	}
	
		@PostMapping ("/novapostagem")
		public ResponseEntity<postagem> PostPostagem (@Valid @RequestBody postagem Postagem) {
			return ResponseEntity.ok(repository.save(Postagem));
		}
		
		@PutMapping ("/atualizarpostagem")
		public ResponseEntity<postagem> PutPostagem (@Valid @RequestBody postagem Postagem){
			return ResponseEntity.ok(repository.save(Postagem));
		}
		
		@DeleteMapping ("/deletar/{idPostagem}")
		public void DeletePostagem (@PathVariable Long idPostagem) {
			repository.deleteById (idPostagem);
		}
	}
	

