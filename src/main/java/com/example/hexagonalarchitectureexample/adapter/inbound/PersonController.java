package com.example.hexagonalarchitectureexample.adapter.inbound;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.hexagonalarchitectureexample.adapter.inbound.dto.PersonDTO;
import com.example.hexagonalarchitectureexample.domain.Person;
import com.example.hexagonalarchitectureexample.port.PersonServicePort;

@RestController
@RequestMapping(value="/api/v1/person")
public class PersonController {

	@Autowired
	private PersonServicePort service;
	
	private ModelMapper mapper = new ModelMapper();
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PersonDTO>> findAll() {
		List<Person> listPerson = service.findAll();
		List<PersonDTO> listPersonDTO = listPerson.stream().map(person -> mapper.map(person, PersonDTO.class)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listPersonDTO);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PersonDTO> find(@PathVariable Long id) {
		Person person = service.findById(id);
		PersonDTO personDTO = mapper.map(person, PersonDTO.class);
		return ResponseEntity.ok().body(personDTO);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<PersonDTO> save(@RequestBody PersonDTO personDTO) {
		Person person = mapper.map(personDTO, Person.class);
		person = service.save(person);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(person.id()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<PersonDTO> update(@RequestBody PersonDTO personDTO, @PathVariable Long id) {
		Person person = mapper.map(personDTO, Person.class);
		person = service.update(person, id);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(person.id()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
