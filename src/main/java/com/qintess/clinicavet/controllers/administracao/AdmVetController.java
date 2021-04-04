package com.qintess.clinicavet.controllers.administracao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qintess.clinicavet.models.Agenda;
import com.qintess.clinicavet.models.Agendamento;
import com.qintess.clinicavet.models.Veterinario;
import com.qintess.clinicavet.services.AgendaService;
import com.qintess.clinicavet.services.AgendamentoService;
import com.qintess.clinicavet.services.VeterinarioService;

//Controller que lida com os dados dos veterinários

@Controller
@RequestMapping("/administracao/vet")
public class AdmVetController {
	
	@Autowired
	VeterinarioService vetServ;
	@Autowired
	AgendamentoService agenServ;

	@RequestMapping("")
	public String vets(Model model) {
		List<Veterinario> veterinarios = vetServ.listaTodos();
		model.addAttribute("veterinarios", veterinarios);
		return "administracao/vetHome";
	}
	
	@RequestMapping("/cadastro")
	public String cadastro(Model model) {
		model.addAttribute("veterinario", new Veterinario());
		return "administracao/cadastroVet";
	}
	
	@RequestMapping("/salva")
	public String salva(@ModelAttribute Veterinario veterinario) {
		vetServ.insere(veterinario);
		return "redirect:/administracao/vet";
	}
	
	@RequestMapping("/{id}")
	public String carregaAlterar(@PathVariable(name="id") Long id, Model model) {
		Veterinario veterinario = vetServ.buscaPorId(id);
		List<Agendamento> agendamentos = agenServ.buscaPorVet(id);
		AgendaService conversor = new AgendaService();
		List<Agenda> agendas = conversor.converteAgendamentos(agendamentos);
		model.addAttribute("veterinario", veterinario);
		model.addAttribute("agendas", agendas);
		return "administracao/consultaAgenda";
	}
	
	@RequestMapping("/altera")
	public String altera(@ModelAttribute Veterinario veterinario, Model model) {
		model.addAttribute("veterinario", veterinario);
		return "administracao/cadastroVet";
	}
	
	@RequestMapping("{vetId}/cancela/{id}")
	public String cancelaAgendamento(@PathVariable(name="id") Long id, @PathVariable(name="vetId") Long vetId) {
		agenServ.deleta(id);
		return "redirect:/administracao/vet/"+vetId;
	}
}
