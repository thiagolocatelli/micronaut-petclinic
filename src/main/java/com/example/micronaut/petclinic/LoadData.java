package com.example.micronaut.petclinic;

import com.example.micronaut.petclinic.owner.OwnerRepository;
import com.example.micronaut.petclinic.owner.PetRepository;
import com.example.micronaut.petclinic.vet.Specialty;
import com.example.micronaut.petclinic.vet.SpecialtyRepository;
import com.example.micronaut.petclinic.vet.Vet;
import com.example.micronaut.petclinic.vet.VetRepository;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LoadData {

    @Inject
    private OwnerRepository ownerRepository;

    @Inject
    private VetRepository vetRepository;

    @Inject
    private PetRepository petRepository;

    @Inject
    private SpecialtyRepository specialtyRepository;

    @EventListener
    void onStartup(StartupEvent event) {

        Specialty radiology = new Specialty();
        radiology.setName("Radiology");
        specialtyRepository.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setName("surgery");
        specialtyRepository.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setName("Dentistry");
        specialtyRepository.save(dentistry);

        Vet James = new Vet();
        James.setFirstName("James");
        James.setLastName("Carter");
        James.addSpecialty(surgery);
        vetRepository.save(James);

        Vet Helen = new Vet();
        Helen.setFirstName("Helen");
        Helen.setLastName("Leary");
        Helen.addSpecialty(radiology);
        vetRepository.save(Helen);

        Vet Linda = new Vet();
        Linda.setFirstName("Linda");
        Linda.setLastName("Douglas");
        Linda.addSpecialty(surgery);
        Linda.addSpecialty(dentistry);
        vetRepository.save(Linda);

        Vet Rafael = new Vet();
        Rafael.setFirstName("Rafael");
        Rafael.setLastName("Ortega");
        Rafael.addSpecialty(surgery);
        vetRepository.save(Rafael);

        Vet Henry = new Vet();
        Henry.setFirstName("Henry");
        Henry.setLastName("Stevens");
        Helen.addSpecialty(radiology);
        vetRepository.save(Helen);

        Vet Sharon = new Vet();
        Sharon.setFirstName("Sharon");
        Sharon.setLastName("Jenkins");
        Sharon.addSpecialty(dentistry);
        Sharon.addSpecialty(radiology);
        Sharon.addSpecialty(surgery);
        vetRepository.save(Sharon);

    }
}
