package com.shamim.pet_clinic.service.map;

import com.shamim.pet_clinic.model.Visit;
import com.shamim.pet_clinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

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
    public Visit save(Visit visit) {
        if(visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null
                || visit.getPet().getOwner().getId() == null){

            if (visit.getPet()== null) System.out.println("object.getPet()== null");
            if ( visit.getPet().getOwner()==null) System.out.println("object.getPet().getOwner()==null");
            if (visit.getPet().getId()==null) System.out.println("object.getPet().getId()==null");
            if (visit.getPet().getOwner().getId()==null) System.out.println("object.getPet().getOwner().getId()==null");

            throw new RuntimeException("Invalid Visit");
        }
        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
