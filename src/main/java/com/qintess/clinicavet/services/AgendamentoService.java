package com.qintess.clinicavet.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.clinicavet.models.Agendamento;
import com.qintess.clinicavet.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired
	AgendamentoRepository agenRepo;

	public void insere(Agendamento agen) {
		agen.setId(null);
		agenRepo.save(agen);
	}

	public Set<Double> buscaHorarios(String dataTexto, Long vetId) {
		Set<Double> horarios = new LinkedHashSet<Double>();
		for (Double i = 7.0; i < 17; i += 0.5) {
			horarios.add(i);
		}
		
		LocalDate data = LocalDate.parse(dataTexto);
		
		List<Agendamento> ocupado = buscaData(data, vetId);
		for (Agendamento agendamento : ocupado) {
			if(horarios.contains(agendamento.getHorario())) {
				horarios.remove(agendamento.getHorario());
			}
		}
		return horarios;
	}

	public List<Agendamento> buscaData(LocalDate data, Long vetId){
		return agenRepo.findByDataAndVeterinario(data, vetId);
	}
	
	public List<String> horaParaTexto(Set<Double> horariosDoub){
		List<String> horariosTexto = new ArrayList<String>();
		for (double horario : horariosDoub) {
			Integer hora =  (int) horario;
			Integer minutos = (int) (horario * 60) % 60;
			String horaTexto;
			if(minutos == 0) {
				horaTexto = String.format("%s:%s0", hora, minutos);
			}else {
				horaTexto = String.format("%s:%s", hora, minutos);
			}
			
			horariosTexto.add(horaTexto);
		}
		return horariosTexto;
	}
	
	public Double textoParaHora(String horaTexto) {
		String[] partes = horaTexto.split(":");
		Double hora = Double.parseDouble(partes[0]);
		Double min = Double.parseDouble(partes[1]);
		min = (min/60);
		Double horario = (hora+min);
		return horario;
	}
	
	public List<Agendamento> buscaPorVet(Long vetId){
		return agenRepo.findAllByVeterinario(vetId);
	}
	
	public void deleta(Long id) {
		agenRepo.deleteById(id);
	}
	
	public Agendamento buscaPorId(Long id) {
		return agenRepo.findById(id).get();
	}
}
