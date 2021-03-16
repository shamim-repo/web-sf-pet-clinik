package com.shamim.pet_clinic.service.map;

import com.shamim.pet_clinic.model.Visit;
import com.shamim.pet_clinic.service.VisitService;

import java.util.Set;


public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

    private final VisitService visitService;

    public VisitServiceMap(VisitService visitService) {
        this.visitService = visitService;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit object) {
        if (object.getPet()== null || object.getPet().getOwner()==null
                || object.getPet().getId()==null || object.getPet().getOwner().getId()==null){
            throw new RuntimeException("Invalid Visit");
        }
        return visitService.save(object);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
