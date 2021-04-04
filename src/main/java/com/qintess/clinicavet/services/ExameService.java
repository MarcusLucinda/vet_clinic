package com.qintess.clinicavet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.clinicavet.models.Exame;
import com.qintess.clinicavet.repositories.ExameRepository;

@Service
public class ExameService {

	@Autowired
	ExameRepository exameRepo;
	
	public List<Exame> listaTodos(){
		return exameRepo.findAll();
	}
	
	public Exame buscaPorId(Long id) {
		return exameRepo.findById(id).get();
	}

	public void insere(Exame exame) {
		exameRepo.save(exame);		
	}
}
