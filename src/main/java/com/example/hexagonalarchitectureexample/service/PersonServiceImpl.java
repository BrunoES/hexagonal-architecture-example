package com.example.hexagonalarchitectureexample.service;

import java.util.List;

import com.example.hexagonalarchitectureexample.domain.Person;
import com.example.hexagonalarchitectureexample.port.PersonRepositoryPort;
import com.example.hexagonalarchitectureexample.port.PersonServicePort;

public class PersonServiceImpl implements PersonServicePort {

	private final PersonRepositoryPort personRepository;
	
	public PersonServiceImpl(PersonRepositoryPort personRepository) {
		super();
		this.personRepository = personRepository;
	}

	@Override
	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person save(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person update(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean publish(Person person) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
