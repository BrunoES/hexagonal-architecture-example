package com.example.hexagonalarchitectureexample.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.hexagonalarchitectureexample.adapter.outbound.persistence.entity.PersonEntity;
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
		return personRepository.findAll().stream().map(personEntity -> personEntity.toDomain()).collect(Collectors.toList());
	}

	@Override
	public Person findById(Long id) {
		return personRepository.findById(id).toDomain();
	}

	@Override
	public Person save(Person person) {
		return personRepository.save(PersonEntity.fromDomain(person.id(), person)).toDomain();
	}

	@Override
	public Person update(Person person, Long id) {
		return personRepository.save(PersonEntity.fromDomain(id, person)).toDomain();
	}

	@Override
	public void deleteById(Long id) {
		personRepository.deleteById(id);
		
	}

	@Override
	public Boolean publish(Person person) throws Exception {
		// Chamar adapter Kafka para publicar pessoa na fila.
		return null;
	}

}
