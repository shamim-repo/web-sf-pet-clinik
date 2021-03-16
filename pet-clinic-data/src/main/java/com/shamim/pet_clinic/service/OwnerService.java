package com.shamim.pet_clinic.service;

import com.shamim.pet_clinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
  
}
