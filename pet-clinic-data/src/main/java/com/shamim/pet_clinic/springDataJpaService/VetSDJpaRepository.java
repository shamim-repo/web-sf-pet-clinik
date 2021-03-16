package com.shamim.pet_clinic.springDataJpaService;

import com.shamim.pet_clinic.model.Vet;
import com.shamim.pet_clinic.repository.VetRepository;
import com.shamim.pet_clinic.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJpa")
public class VetSDJpaRepository implements VetService {

    private final VetRepository vetRepository;

    public VetSDJpaRepository(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vetSet=new HashSet<>();
        vetRepository.findAll().iterator().forEachRemaining(vetSet::add);
        return vetSet;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
