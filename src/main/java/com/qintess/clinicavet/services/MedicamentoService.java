package com.qintess.clinicavet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.clinicavet.models.Medicamento;
import com.qintess.clinicavet.repositories.MedicamentoRepository;

@Service
public class MedicamentoService {

	@Autowired
	MedicamentoRepository medicamentoRepo;
	
	public void insere(Medicamento medicamento) {
		medicamentoRepo.save(medicamento);
	}
	
	public List<Medicamento> listaTodos(){
		return medicamentoRepo.findAll();
	}
	
	public Medicamento buscaPorId(Long id) {
		return medicamentoRepo.findById(id).get();
	}
}
