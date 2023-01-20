package com.example.hexagonalarchitectureexample.domain;

import com.example.hexagonalarchitectureexample.domain.enums.PersonNationality;

public record Person(Long id, String name, String address, Integer age, PersonNationality nationality) {

}
