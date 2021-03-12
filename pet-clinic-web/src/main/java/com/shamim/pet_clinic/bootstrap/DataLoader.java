package com.shamim.pet_clinic.bootstrap;

import com.shamim.pet_clinic.model.Owner;
import com.shamim.pet_clinic.model.Vet;
import com.shamim.pet_clinic.service.OwnerService;
import com.shamim.pet_clinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1=new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Shamim");
        owner1.setLastName("Bhuiyan");

        ownerService.save(owner1);

        Owner owner2=new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Sharif");
        owner2.setLastName("Chaudhory");

        ownerService.save(owner2);

        System.out.println("Loading Owner......");

        Vet vet1=new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Abid");
        vet1.setLastName("Bhuiyan");

        vetService.save(vet1);

        Vet vet2=new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Tamim");
        vet2.setLastName("Copy");

        vetService.save(vet2);

        System.out.println("Loading Vets.......");

    }
}
