package com.example.hexagonalarchitectureexample.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.hexagonalarchitectureexample.adapter.inbound.dto.PersonDTO;
import com.example.hexagonalarchitectureexample.adapter.outbound.persistence.entity.PersonEntity;
import com.example.hexagonalarchitectureexample.domain.Person;
import com.example.hexagonalarchitectureexample.port.KafkaProducerServicePort;
import com.example.hexagonalarchitectureexample.port.PersonRepositoryPort;
import com.example.hexagonalarchitectureexample.port.PersonServicePort;

public class PersonServiceImpl implements PersonServicePort {

	private final PersonRepositoryPort personRepository;
	
	private final KafkaProducerServicePort<PersonDTO> kafkaProducerService;
	
	public PersonServiceImpl(PersonRepositoryPort personRepository, KafkaProducerServicePort<PersonDTO> kafkaProducerService) {
		super();
		this.personRepository = personRepository;
		this.kafkaProducerService = kafkaProducerService;
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
	public void publish(Person person) throws Exception {
		String key = UUID.randomUUID().toString();
		PersonDTO personDTO = new PersonDTO(person.id(), person.name(), person.address(), person.age());
		kafkaProducerService.send("MEUUSADO.ANNOUNCEMENT-VALIDATION", key, personDTO);
	}

}
