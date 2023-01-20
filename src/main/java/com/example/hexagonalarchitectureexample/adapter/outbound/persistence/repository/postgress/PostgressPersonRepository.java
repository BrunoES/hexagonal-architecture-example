package com.example.hexagonalarchitectureexample.adapter.outbound.persistence.repository.postgress;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.hexagonalarchitectureexample.adapter.outbound.persistence.entity.PersonEntity;
import com.example.hexagonalarchitectureexample.adapter.outbound.persistence.repository.spring.SpringDataPersonRepository;
import com.example.hexagonalarchitectureexample.port.PersonRepositoryPort;

@Component
@Primary
public class PostgressPersonRepository implements PersonRepositoryPort {

	@Autowired
	private SpringDataPersonRepository repository;
	
	@Override
	public List<PersonEntity> findAll() {
		return repository.findAll();
	}

	@Override
	public PersonEntity findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public PersonEntity save(PersonEntity personEntity) {
		return repository.save(personEntity);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
