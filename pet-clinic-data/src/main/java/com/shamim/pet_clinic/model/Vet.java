/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shamim.pet_clinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Root
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vets")
public class Vet extends Person {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(name = "vet_id")
                                           ,inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities =new HashSet<>();


    @Builder
    public Vet(Long id,String firstName,String lastName,Set<Speciality> specialities) {
        super(id,firstName,lastName);
        this.specialities = specialities;
    }
}
