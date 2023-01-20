package com.example.hexagonalarchitectureexample.adapter.outbound.persistence.repository.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hexagonalarchitectureexample.adapter.outbound.persistence.entity.PersonEntity;

@Repository
public interface SpringDataPersonRepository extends JpaRepository<PersonEntity, Long> {

}