package com.qintess.clinicavet.controllers.administracao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qintess.clinicavet.models.Exame;
import com.qintess.clinicavet.services.ExameService;

//Controller que lida com a base de dados de exames

@Controller
@RequestMapping("administracao/exames")
public class AdmExameController {

	@Autowired
	ExameService exameServ;
	
	@RequestMapping("")
	public String listaExames(Model model) {
		List<Exame> exames = exameServ.listaTodos();
		model.addAttribute("exames", exames);
		return "administracao/admExames";
	}
	
	@RequestMapping("/cadastro")
	public String cadastro(Model model) {
		model.addAttribute("exame", new Exame());
		return "administracao/admCadastroExame";
	}
	
	@RequestMapping("/salva")
	public String salva(@ModelAttribute Exame exame) {
		exameServ.insere(exame);
		return "redirect:/administracao/exames";
	}
	
	@RequestMapping("/altera/{id}")
	public String altera(@PathVariable(name="id") Long id, Model model) {
		Exame exame = exameServ.buscaPorId(id);
		model.addAttribute("exame", exame);
		return "administracao/admCadastroExame";
	}
	
}
