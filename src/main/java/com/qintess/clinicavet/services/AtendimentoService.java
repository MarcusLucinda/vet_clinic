package com.qintess.clinicavet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.clinicavet.models.Atendimento;
import com.qintess.clinicavet.models.Veterinario;
import com.qintess.clinicavet.repositories.AtendimentoRepository;

@Service
public class AtendimentoService {
	
	@Autowired
	AtendimentoRepository atendRepo;
	
	public void insere(Atendimento atendimento) {
		System.out.println(atendimento.getHorario());
		System.out.println(atendimento.getId());
		atendRepo.save(atendimento);
	}
	
	public List<Atendimento> buscaPorVet(Veterinario veterinario){
		return atendRepo.findAllByVeterinario(veterinario);
	}
	
	public Atendimento buscaPorId(Long id) {
		return atendRepo.findById(id).get();
	}
}
