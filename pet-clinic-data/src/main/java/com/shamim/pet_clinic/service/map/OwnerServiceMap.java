package com.shamim.pet_clinic.service.map;

import com.shamim.pet_clinic.model.Owner;
import com.shamim.pet_clinic.model.Pet;
import com.shamim.pet_clinic.service.OwnerService;
import com.shamim.pet_clinic.service.PetService;
import com.shamim.pet_clinic.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        if(object!=null) {
            if (object.getPets() !=null){
                object.getPets().forEach(pet -> {
                    if (pet.getPetType()!=null){
                        if (pet.getPetType().getId()==null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else throw new RuntimeException("Pet Type is required");
                    if(pet.getId()== null){
                        Pet savedPet=petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }else
                return super.save(object);
        }
         return null;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
