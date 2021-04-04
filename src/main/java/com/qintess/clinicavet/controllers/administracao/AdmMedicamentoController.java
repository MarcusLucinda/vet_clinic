package com.qintess.clinicavet.controllers.administracao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qintess.clinicavet.models.Medicamento;
import com.qintess.clinicavet.services.MedicamentoService;

//Controller que lida com a base de dados de medicamentos

@Controller
@RequestMapping("/administracao/medicamentos")
public class AdmMedicamentoController {

	@Autowired
	MedicamentoService medicamentoServ;
	
	@RequestMapping("")
	public String listaMedicamentos(Model model) {
		List<Medicamento> medicamentos = medicamentoServ.listaTodos();
		model.addAttribute("medicamentos", medicamentos);
		return "/administracao/admMedicamentos";
	}
	
	@RequestMapping("/cadastro")
	public String cadastro(Model model) {
		model.addAttribute("medicamento", new Medicamento());
		return "administracao/admCadastroMedicamento";
	}
	
	@RequestMapping("/salva")
	public String salva(@ModelAttribute Medicamento medicamento) {
		medicamentoServ.insere(medicamento);
		return "redirect:/administracao/medicamentos";
	}
	
	@RequestMapping("/altera/{id}")
	public String altera(@PathVariable(name="id") Long id, Model model) {
		Medicamento medicamento = medicamentoServ.buscaPorId(id);
		model.addAttribute("medicamento", medicamento);
		return "administracao/admCadastroMedicamento";
	}
	
}
