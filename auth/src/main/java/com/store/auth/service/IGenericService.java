package com.store.auth.service;

import java.util.List;

public interface IGenericService<T> {

	List<T> getAll();
	
	T get(Long id, String noSuchElementExeption);
	
	void save(T item);
	
	void update(T item);
	
	void delete(Long id);
}
