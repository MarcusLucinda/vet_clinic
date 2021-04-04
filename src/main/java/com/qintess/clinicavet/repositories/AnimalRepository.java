package com.qintess.clinicavet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qintess.clinicavet.models.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
