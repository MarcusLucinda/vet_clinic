package com.qintess.clinicavet.controllers.agendamento;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.qintess.clinicavet.models.Agendamento;
import com.qintess.clinicavet.models.Animal;
import com.qintess.clinicavet.models.Dono;
import com.qintess.clinicavet.services.AnimalService;

//Controller que trata o cadastro de um novo animal durante o agendamento

@Controller
@SessionAttributes("ag")
@RequestMapping("agendamento/cadastroanimal")
public class AgCadastroAnimalController {

	@Autowired
	AnimalService animalServ;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String novoAnimal(@ModelAttribute("dono") Dono dono, Model model) {
		System.out.println(dono.getNome());
		Animal animal = new Animal();
		animal.setDono(dono);
		model.addAttribute("novoAnimal", animal);
		return "agendamento/cadastroAnimal";
	}

	@RequestMapping("/salva")
	public String salvaAnimal(@Valid @ModelAttribute Animal animal, 
			@ModelAttribute("ag") Agendamento agendamento) {
		animalServ.salva(animal);
		agendamento.setAnimal(animal);
		return "redirect:/agendamento/vet/selecionavet";
	}
}
