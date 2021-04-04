package com.qintess.clinicavet.controllers.agendamento;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.qintess.clinicavet.models.Agendamento;
import com.qintess.clinicavet.services.AgendamentoService;

//Controller responsável pelos dados das agendas dos veterinários

@Controller
@SessionAttributes("ag")
@RequestMapping("agendamento/agenda")
public class AgAgendaController {

	@Autowired
	AgendamentoService agenServ;

	@RequestMapping("")
	public String agendaHoje(@ModelAttribute("ag") Agendamento agendamento, Model model){
		LocalDate dataAmanha = LocalDate.now().plusDays(1);
		String amanhaTxt = dataAmanha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Set<Double> disponivel = agenServ.buscaHorarios(amanhaTxt, agendamento.getVeterinario().getId());
		List<String> horaTexto = agenServ.horaParaTexto(disponivel);
		if(dataAmanha.getDayOfWeek().getValue() == 6 || dataAmanha.getDayOfWeek().getValue() == 7) {
			horaTexto = null;
		}else {
			agendamento.setData(dataAmanha);
		}
		model.addAttribute("horarios", horaTexto);
		model.addAttribute("diaEscolhido", amanhaTxt);
		model.addAttribute("dataTexto", dataAmanha.format(DateTimeFormatter.ofPattern("dd/MM/yy")));
		return "agendamento/agenda";
	}

	@RequestMapping(value="/datas", method=RequestMethod.POST)
	public String datas(@RequestParam String dia, @ModelAttribute("ag") Agendamento agendamento, 
			Model model) {
		Set<Double> disponivel = agenServ.buscaHorarios(dia, agendamento.getVeterinario().getId());
		List<String> horaTexto = agenServ.horaParaTexto(disponivel);
		LocalDate dataEsc = LocalDate.parse(dia);
		if(dataEsc.isBefore(LocalDate.now()) == true || dataEsc.isEqual(LocalDate.now()) == true ||
				dataEsc.getDayOfWeek().getValue() == 6 || dataEsc.getDayOfWeek().getValue() == 7){
			horaTexto = null;
		}
		else {
			agendamento.setData(dataEsc);
		}
		model.addAttribute("horarios", horaTexto);
		model.addAttribute("diaEscolhido", dia);
		model.addAttribute("dataTexto", dataEsc.format(DateTimeFormatter.ofPattern("dd/MM/yy")));
		return "agendamento/agenda";
	}

	@RequestMapping("/agendar/{hora}")
	public String agendar(@PathVariable String hora, @ModelAttribute("ag") Agendamento agendamento) {
		Double tempo = agenServ.textoParaHora(hora);
		agendamento.setHorario(tempo);
		agenServ.insere(agendamento);
		return "index";
	}
}
