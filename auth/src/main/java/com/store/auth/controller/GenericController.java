package com.store.auth.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.store.auth.service.IGenericService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GenericController<T> {
    private final IGenericService<T> service;
/*
    public GenericController(IGenericService<T> service) {
    	this.service = service;
	}
*/
	@GetMapping
    public ResponseEntity<List<T>> getAll(){
        List<T> items = service.getAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> get(@PathVariable Long id, String noSuchElementException){
        try {
        	T item = service.get(id, noSuchElementException);
        	return new ResponseEntity<>(item, HttpStatus.OK);
		
		} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
        
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody T item){
        service.save(item);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody T item){
        service.update(item);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}