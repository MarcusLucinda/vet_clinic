package com.qintess.clinicavet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.clinicavet.models.Veterinario;
import com.qintess.clinicavet.repositories.VeterinarioRepository;

@Service
public class VeterinarioService {

	@Autowired
	VeterinarioRepository vetRepo;
	
	public void insere(Veterinario vet) {
		vetRepo.save(vet);
	}
	
	public List<Veterinario> listaTodos(){
		return vetRepo.findAll();
	}
	
	public Veterinario buscaPorId(Long id) {
		return vetRepo.findById(id).get();
	}
	
	public List<Veterinario> listaEspecialidade(String espec){
		return vetRepo.findAllByEspecialidade(espec);
	}
}
