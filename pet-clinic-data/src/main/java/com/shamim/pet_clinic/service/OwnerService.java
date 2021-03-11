package com.shamim.pet_clinic.service;

import com.shamim.pet_clinic.model.Owner;
import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
  
}
