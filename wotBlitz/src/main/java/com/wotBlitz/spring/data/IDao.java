package com.wotBlitz.spring.data;

import java.util.List;
		
public interface IDao<K, E>{

	E save(E entity);

	E update(E entity);

	void remove(K id);

	E findById(K id);

	List<E> findAll();

	void closeResource();
}
