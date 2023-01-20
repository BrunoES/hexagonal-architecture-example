package com.example.hexagonalarchitectureexample.port;

import java.util.List;

import com.example.hexagonalarchitectureexample.adapter.outbound.persistence.entity.PersonEntity;

public interface PersonRepositoryPort {

	List<PersonEntity> findAll();
	
	PersonEntity findById(Long id);
	
	PersonEntity save(PersonEntity person);
	
	void deleteById(Long id);
	
}
