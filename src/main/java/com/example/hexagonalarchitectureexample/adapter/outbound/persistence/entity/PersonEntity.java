package com.example.hexagonalarchitectureexample.adapter.outbound.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.hexagonalarchitectureexample.domain.enums.PersonNationality;

@Entity
@Table(name = "TBL_PERSON")
public class PersonEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SG_PERSON")
    @SequenceGenerator(name =  "SG_PERSON",sequenceName = "SQ_PERSON")
	@Column(name="ID")
	private Long id;

	@Column(name="NAME")
	private String name;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="AGE")
	private Integer age;
	
	@Column(name="NATIONALITY")
	private PersonNationality nationality;

	public PersonEntity(Long id, String name, String address, Integer age, PersonNationality nationality) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.age = age;
		this.nationality = nationality;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public Integer getAge() {
		return age;
	}

	public PersonNationality getNationality() {
		return nationality;
	}
	
}
