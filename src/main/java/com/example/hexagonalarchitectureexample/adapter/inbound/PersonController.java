package com.example.hexagonalarchitectureexample.adapter.inbound;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.hexagonalarchitectureexample.adapter.inbound.dto.PersonDTO;
import com.example.hexagonalarchitectureexample.port.PersonServicePort;

@RestController
@RequestMapping(value="/api/v1/person")
public class PersonController {

	@Autowired
	private PersonServicePort service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PersonDTO>> findAll() {
		return null;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PersonDTO> find(@PathVariable Long id) {
		return null;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<PersonDTO> save(@RequestBody PersonDTO veiculoDto) {
		return null;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<PersonDTO> update(@RequestBody PersonDTO veiculoDto, @PathVariable Long id) {
		return null;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return null;
	}
}
