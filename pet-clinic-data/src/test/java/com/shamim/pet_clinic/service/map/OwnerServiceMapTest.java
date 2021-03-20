package com.shamim.pet_clinic.service.map;

import com.shamim.pet_clinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long id=1L;
    final String lastName="smith";


    @BeforeEach
    void setUp() {
        ownerServiceMap=new OwnerServiceMap(new PetServiceMap(),new PetTypeServiceMap());
        ownerServiceMap.save(Owner.builder().id(id).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet=ownerServiceMap.findAll();
        assertEquals(1,ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(id);
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(id));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void saveExistingId() {
        long id2 = 2L;
        Owner owner2=Owner.builder().id(id2).build();
        Owner savedOwner=ownerServiceMap.save(owner2);
        assertEquals(id2,owner2.getId());
    }
    @Test
    void saveNoId() {
        Owner owner=Owner.builder().build();
        Owner savedOwner=ownerServiceMap.save(owner);
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findById() {
        Owner owner=ownerServiceMap.findById(id);
        assertEquals(id,owner.getId());
    }

    @Test
    void findByLastName() {
        Owner smith=ownerServiceMap.findByLastName(lastName);
        assertNotNull(smith);
        assertEquals(id,smith.getId());
    }
}