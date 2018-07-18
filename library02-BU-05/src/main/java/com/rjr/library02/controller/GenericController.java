package com.rjr.library02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rjr.library02.entities.GenericEntity;
import com.rjr.library02.repository.GenericRepository;

public class GenericController<T extends GenericEntity> {
	
	@Autowired
	private GenericRepository<T> gr;
	
	@GetMapping
	public ResponseEntity<List<T>> readAll() {
		return new ResponseEntity<List<T>>(gr.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<T> readOne(@PathVariable Integer id) {
		return new ResponseEntity<T>(gr.getOne(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<T> create(T oggetto) {
		return new ResponseEntity<T>(gr.save(oggetto), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<T> update(@RequestBody T oggetto) {
		if (gr.getOne(oggetto.getId()) != null) {
			return new ResponseEntity<T>(gr.save(oggetto), HttpStatus.OK);
		} else {
			return new ResponseEntity<T>(HttpStatus.NOT_FOUND);
		}
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> delete(@PathVariable Integer id) {
		if (gr.getOne(id) != null) {
			gr.deleteById(id);
			return new ResponseEntity<Integer>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		}
		
	}

}
