package com.example.hexagonalarchitectureexample.port;

import java.util.List;

import com.example.hexagonalarchitectureexample.domain.Person;

public interface PersonServicePort {
	
	List<Person> findAll();
	
	Person findById(Long id);
	
	Person save(Person person);
	
	Person update(Person person, Long id);
	
	void deleteById(Long id);
	
	void publish(Person person) throws Exception;
}
