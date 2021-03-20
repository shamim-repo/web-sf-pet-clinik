package com.shamim.pet_clinic.springDataJpaService;

import com.shamim.pet_clinic.model.Owner;
import com.shamim.pet_clinic.repository.OwnerRepository;
import com.shamim.pet_clinic.repository.PetRepository;
import com.shamim.pet_clinic.repository.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    @Mock
    PetRepository petRepository;
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    final String lastName="smith";
    final long id = 1L;
    Owner returnOwner;
    @BeforeEach
    void setUp() {
        returnOwner=Owner.builder().id(id).lastName(lastName).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner owner1=ownerSDJpaService.findByLastName(lastName);
        assertNotNull(owner1);
        assertEquals(lastName,owner1.getLastName());
        verify(ownerRepository,times(1)).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet=new HashSet<>();
        ownerSet.add(returnOwner);
        when(ownerRepository.findAll()).thenReturn(ownerSet);
        Set<Owner> ownerSet2=ownerSDJpaService.findAll();
        assertNotNull(ownerSet2);
        assertEquals(ownerSet.size(),ownerSet2.size());
        verify(ownerRepository,times(1)).findAll();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(returnOwner));
        Owner owner1=ownerSDJpaService.findById(id);
        assertNotNull(owner1);
        assertEquals(id,owner1.getId());verify(ownerRepository,times(1)).findById(anyLong());

    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn((returnOwner));
        Owner owner1=ownerSDJpaService.save(returnOwner);
        assertNotNull(owner1);
        assertEquals(id,owner1.getId());
        verify(ownerRepository,times(1)).save(any());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(returnOwner);
        verify(ownerRepository,times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(id);
        verify(ownerRepository,times(1)).deleteById(anyLong());
    }
}