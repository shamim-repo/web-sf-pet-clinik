package com.shamim.pet_clinic.bootstrap;

import com.shamim.pet_clinic.model.Owner;
import com.shamim.pet_clinic.model.Pet;
import com.shamim.pet_clinic.model.PetType;
import com.shamim.pet_clinic.model.Vet;
import com.shamim.pet_clinic.service.OwnerService;
import com.shamim.pet_clinic.service.PetTypeService;
import com.shamim.pet_clinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {


        PetType dog=new PetType();
        dog.setName("Dog");
        PetType savedDogType=petTypeService.save(dog);

        PetType cat=new PetType();
        dog.setName("Cat");
        PetType savedCatType=petTypeService.save(cat);

        System.out.println("Loading PetType.......");


        Owner owner1=new Owner();
        owner1.setFirstName("Shamim");
        owner1.setLastName("Bhuiyan");
        owner1.setAddress("125,Shdh jdn");
        owner1.setCity("Feni");
        owner1.setTelephone("515121551101");

        Pet makePet=new Pet();
        makePet.setPetType(savedDogType);
        makePet.setOwner(owner1);
        makePet.setName("Jack");
        makePet.setBirthDate(LocalDate.now());
        owner1.getPets().add(makePet);

        ownerService.save(owner1);

        Owner owner2=new Owner();
        owner2.setFirstName("Sharif");
        owner2.setLastName("Chaudhory");
        owner2.setAddress("888,snjd cd");
        owner2.setCity("Dhaka");
        owner2.setTelephone("8844511");

        Pet makePet2=new Pet();
        makePet2.setPetType(savedCatType);
        makePet2.setOwner(owner2);
        makePet2.setName("Fiona");
        makePet2.setBirthDate(LocalDate.now());
        ownerService.save(owner2);
        owner2.getPets().add(makePet2);
        ownerService.save(owner2);
        
        System.out.println("Loading Owner......");

        Vet vet1=new Vet();
        vet1.setFirstName("Abid");
        vet1.setLastName("Bhuiyan");

        vetService.save(vet1);

        Vet vet2=new Vet();
        vet2.setFirstName("Tamim");
        vet2.setLastName("Copy");

        vetService.save(vet2);

        System.out.println("Loading Vets.......");


    }
}
