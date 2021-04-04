package com.qintess.clinicavet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.clinicavet.models.Animal;
import com.qintess.clinicavet.repositories.AnimalRepository;

@Service
public class AnimalService {

	@Autowired
	AnimalRepository animalRep;
	
	public void salva(Animal animal) {
		animalRep.save(animal);
	}
	
	public Animal buscaPorId(Long id) {
		return animalRep.findById(id).get();
		
	}
}
