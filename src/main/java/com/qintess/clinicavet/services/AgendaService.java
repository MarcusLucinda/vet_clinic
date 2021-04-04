package com.qintess.clinicavet.services;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.qintess.clinicavet.models.Agenda;
import com.qintess.clinicavet.models.Agendamento;

public class AgendaService {

	public List<Agenda> converteAgendamentos(List<Agendamento> agendamentos) {
		List<Agenda> agendas = new ArrayList<Agenda>();
		for (Agendamento agendamento : agendamentos) {
			Agenda agenda = new Agenda();
			agenda.setId(agendamento.getId());
			agenda.setCliente(agendamento.getAnimal().getDono().getNome());
			agenda.setAnimal(agendamento.getAnimal().getEspecie());
			agenda.setData(agendamento.getData().format(DateTimeFormatter.ofPattern("dd/MM/yy")));
			double horario = agendamento.getHorario();
			Integer hora =  (int) horario;
			Integer minutos = (int) (horario * 60) % 60;
			String horaTexto;
			if(minutos == 0) {
				horaTexto = String.format("%s:%s0", hora, minutos);
			}else {
				horaTexto = String.format("%s:%s", hora, minutos);
			}
			agenda.setHorario(horaTexto);
			agendas.add(agenda);
		}
		return agendas;
	}
}
