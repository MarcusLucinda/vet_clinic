package com.qintess.clinicavet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.clinicavet.models.Animal;
import com.qintess.clinicavet.models.Dono;
import com.qintess.clinicavet.repositories.DonoRepository;

@Service
public class DonoService {

	@Autowired
	private DonoRepository donoRep;
	
	public Dono insere(Dono dono) {
		return donoRep.saveAndFlush(dono);
	}
	
	public Dono buscaId(Long cpf) {
		try {
			return donoRep.findById(cpf).get();
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Dono> listaTodos() {
		return donoRep.findAll();
	}
	
	public List<Animal> listaAnimais(Dono dono){
		return dono.getAnimais();
	}
}
