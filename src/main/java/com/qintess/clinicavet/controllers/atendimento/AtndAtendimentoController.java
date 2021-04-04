package com.qintess.clinicavet.controllers.atendimento;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.qintess.clinicavet.models.Agenda;
import com.qintess.clinicavet.models.Agendamento;
import com.qintess.clinicavet.models.Atendimento;
import com.qintess.clinicavet.models.Exame;
import com.qintess.clinicavet.models.Medicamento;
import com.qintess.clinicavet.models.Observacoes;
import com.qintess.clinicavet.models.Veterinario;
import com.qintess.clinicavet.services.AgendaService;
import com.qintess.clinicavet.services.AgendamentoService;
import com.qintess.clinicavet.services.AtendimentoService;
import com.qintess.clinicavet.services.ExameService;
import com.qintess.clinicavet.services.MedicamentoService;
import com.qintess.clinicavet.services.VeterinarioService;

//Controller que trata da parte final do registro de atendimento

@Controller
@SessionAttributes({"atnd", "agen"})
@RequestMapping("/atendimento")
public class AtndAtendimentoController {
	
	@ModelAttribute("atnd")
    public Atendimento getAtnd() {
        return new Atendimento();
    }
	
	@ModelAttribute("agen")
    public Agendamento getAgen() {
        return new Agendamento();
    }
	
	@Autowired
	VeterinarioService vetServ;
	@Autowired
	AgendamentoService agenServ;
	@Autowired
	MedicamentoService medicamentoServ;
	@Autowired
	ExameService exameServ;
	@Autowired
	AtendimentoService atendServ;
	

	@RequestMapping("/vet")
	public String atndHome(Model model, @ModelAttribute("atnd") Atendimento atendimento,
			@ModelAttribute("agen") Agendamento agendamento) {
		atendimento = new Atendimento();
		agendamento = new Agendamento();
		model.addAttribute("veterinarios", vetServ.listaTodos());
		return "atendimento/atndSelecionaVet";
	}
	
	@RequestMapping("/vet/{id}")
	public String agenda(@PathVariable(name="id") Long vetId, @ModelAttribute("atnd") Atendimento atendimento,
			Model model) {
		Veterinario vet = vetServ.buscaPorId(vetId);
		List<Agendamento> agendamentos = agenServ.buscaPorVet(vetId);
		AgendaService conversor = new AgendaService();
		List<Agenda> agendas = conversor.converteAgendamentos(agendamentos);
		atendimento.setVeterinario(vet);
		atendimento.setMedicamentos(new ArrayList<Medicamento>());
		atendimento.setExames(new ArrayList<Exame>());
		model.addAttribute("veterinario", vet);
		model.addAttribute("agendas", agendas);
		return "atendimento/atndSelecionaConsulta";
	}
	
	@RequestMapping("/vet/{vetId}/registra/{id}")
	public String caracterizaAtendimento(@PathVariable(name="id") Long id, @PathVariable(name="vetId") Long vetId, 
			@ModelAttribute("atnd") Atendimento atendimento, @ModelAttribute("agen") Agendamento agendamento,
			Model model) {
		agendamento = agenServ.buscaPorId(id);
		atendimento.setId(id);
		double horario = agendamento.getHorario();
		Integer horas =  (int) horario;
		Integer minutos = (int) ((horario * 60) % 60);
		atendimento.setHorario(LocalDateTime.of(agendamento.getData(), LocalTime.of(horas, minutos)));
		atendimento.setAnimal(agendamento.getAnimal());
		model.addAttribute("agendamento", agendamento);
		model.addAttribute("medicamentos", atendimento.getMedicamentos());
		model.addAttribute("exames", atendimento.getExames());
		model.addAttribute("observacoes", new Observacoes());
		return "atendimento/atndRegistro";
	}
	
	@RequestMapping("vet/{vetId}/registra/{atenId}/medicamentos")
	public String medicamentos(Model model, @PathVariable(name="atenId") Long atenId, 
			@PathVariable(name="vetId") Long vetId){
		model.addAttribute("medicamentos", medicamentoServ.listaTodos());
		return "atendimento/atndSelecionaMedicamento";
	}
	
	@RequestMapping("vet/medicamento/{medId}")
	public String registraMedicamento(@PathVariable(name="medId") Long medId, @ModelAttribute("atnd") Atendimento atendimento) {
		Medicamento medicamento = medicamentoServ.buscaPorId(medId);
		List<Medicamento> medicamentos = atendimento.getMedicamentos();
		medicamentos.add(medicamento);
		atendimento.setMedicamentos(medicamentos);
		return "redirect:/atendimento/vet/"+atendimento.getVeterinario().getId()+"/registra/"+atendimento.getId();
	}
	
	@RequestMapping("vet/{vetId}/registra/{atenId}/exames")
	public String exames(Model model, @PathVariable(name="atenId") Long atenId, 
			@PathVariable(name="vetId") Long vetId){
		model.addAttribute("exames", exameServ.listaTodos());
		return "atendimento/atndSelecionaExame";
	}
	
	@RequestMapping("vet/exame/{exId}")
	public String registraExame(@PathVariable(name="exId") Long exId, @ModelAttribute("atnd") Atendimento atendimento) {
		Exame exame = exameServ.buscaPorId(exId);
		List<Exame> exames = atendimento.getExames();
		exames.add(exame);
		atendimento.setExames(exames);
		return "redirect:/atendimento/vet/"+atendimento.getVeterinario().getId()+"/registra/"+atendimento.getId();
	}
	
	@RequestMapping("vet/registrar")
	public String registraAtendimento(@ModelAttribute("atnd") Atendimento atendimento, @ModelAttribute Observacoes observacoes) {
		atendimento.setObservacoes(observacoes.getObs());
		atendServ.insere(atendimento);
		agenServ.deleta(atendimento.getId());
		return "redirect:/atendimento/vet";
	}
	
}
