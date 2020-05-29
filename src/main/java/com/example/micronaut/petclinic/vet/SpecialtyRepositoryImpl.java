package com.example.micronaut.petclinic.vet;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.core.annotation.TypeHint;

import javax.inject.Singleton;
import javax.persistence.EntityManager;

import static io.micronaut.core.annotation.TypeHint.AccessType.ALL_DECLARED_FIELDS;
import static io.micronaut.core.annotation.TypeHint.AccessType.ALL_PUBLIC_CONSTRUCTORS;
import static io.micronaut.core.annotation.TypeHint.AccessType.ALL_PUBLIC_METHODS;

@Singleton
@TypeHint(accessType = {ALL_PUBLIC_CONSTRUCTORS, ALL_DECLARED_FIELDS, ALL_PUBLIC_METHODS})
public class SpecialtyRepositoryImpl implements SpecialtyRepository {

    private final EntityManager entityManager;

    public SpecialtyRepositoryImpl(@CurrentSession EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Specialty specialty) {
        if (specialty.isNew()) {
            entityManager.persist(specialty);
        } else {
            entityManager.merge(specialty);
        }
    }
}
