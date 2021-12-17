package com.example.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.example.cadastro.model.Cadastro;
import com.example.cadastro.repository.CadastroRepository;

@RestController
@RequestMapping("/cadastro")
@CrossOrigin("*")
public class CadastroController {
	
	@Autowired
	private CadastroRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Cadastro>> GelAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cadastro> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	public ResponseEntity<Cadastro> post (@RequestBody Cadastro cadastro){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cadastro));
	}
	
	@PutMapping
	public ResponseEntity<Cadastro> put (@RequestBody Cadastro cadastro){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(cadastro));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
}
