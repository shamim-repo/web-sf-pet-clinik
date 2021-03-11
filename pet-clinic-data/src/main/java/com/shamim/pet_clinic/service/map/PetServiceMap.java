package com.shamim.pet_clinic.service.map;

import com.shamim.pet_clinic.model.Pet;
import com.shamim.pet_clinic.service.CrudService;

import java.util.Set;

public abstract class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet,Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
