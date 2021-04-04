package com.qintess.clinicavet.controllers.administracao;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.qintess.clinicavet.models.Animal;
import com.qintess.clinicavet.models.Dono;
import com.qintess.clinicavet.services.AnimalService;

//Controller responsável pelo controle da parte de animais da administração

@Controller
@RequestMapping("/administracao/animal")
public class AdmAnimalController {

	@Autowired
	AnimalService animalServ;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String novoAnimal(@ModelAttribute("dono") Dono dono, Model model) {
		Animal animal = new Animal();
		animal.setDono(dono);
		model.addAttribute("novoAnimal", animal);
		return "administracao/admCadastroAnimal";
	}
	
	@RequestMapping("/salva")
	public String salvaAnimal(@Valid @ModelAttribute Animal animal) {
		animalServ.salva(animal);
		String cpf = animal.getDono().getCpf().toString();
		return "redirect:/administracao/cliente/"+cpf;
	}
	
	@RequestMapping(value="/altera", method=RequestMethod.POST)
	public String selecionaAnimal(@RequestParam Long id, Model model) {
		Animal animal = animalServ.buscaPorId(id);
		model.addAttribute("novoAnimal", animal);
		return "administracao/admCadastroAnimal";
	}
}
