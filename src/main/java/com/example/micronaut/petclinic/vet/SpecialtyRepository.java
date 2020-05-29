package com.example.micronaut.petclinic.vet;

import io.micronaut.spring.tx.annotation.Transactional;

public interface SpecialtyRepository {

    @Transactional
    void save(Specialty specialty);
}
