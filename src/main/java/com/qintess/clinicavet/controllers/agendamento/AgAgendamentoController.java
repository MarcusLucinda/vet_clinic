package com.qintess.clinicavet.controllers.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.qintess.clinicavet.models.Agendamento;
import com.qintess.clinicavet.models.Animal;
import com.qintess.clinicavet.models.Dono;
import com.qintess.clinicavet.services.AnimalService;
import com.qintess.clinicavet.services.DonoService;

//Controller que trata a parte inicial de um agendamento, direcionando a seleção
//e cadastro de clientes e seus animais

@Controller
@SessionAttributes("ag")
@RequestMapping("/agendamento")
public class AgAgendamentoController {
	
	@ModelAttribute("ag")
    public Agendamento getAg() {
        return new Agendamento();
    }
	
	@Autowired
	DonoService donoServ;
	@Autowired
	AnimalService animalServ;

	@RequestMapping("")
	public String agendamentoHome(Model model) {
		model.addAttribute("vazio", new Dono());
		return "agendamento/agendamento";
	}
	
	@RequestMapping(value="/busca", method=RequestMethod.POST)
	public String buscaDono(Model model, @RequestParam("cpfDono") String cpfs) {
		Long cpf = Long.parseLong(cpfs);
		Dono dono = donoServ.buscaId(cpf);
		if(dono == null) {
			return "redirect:/agendamento/cadastrocliente/"+cpf;
		}else {
			return "redirect:/agendamento/"+cpf;
		}
	}
	
	@RequestMapping("/{cpf}")
	public String carregaAlterar(@PathVariable(name="cpf") Long cpf, Model model) {
		Dono dono = donoServ.buscaId(cpf);
		model.addAttribute("dono", dono);
		model.addAttribute("animais", donoServ.listaAnimais(dono));
		model.addAttribute("animal", new Animal());
		return "agendamento/agendamento";
	}
	
	
	@RequestMapping(value="/seleciona", method=RequestMethod.POST)
	public RedirectView selecionaAnimal(@RequestParam Long id, @ModelAttribute("ag") Agendamento agendamento) {
		Animal animal = animalServ.buscaPorId(id);
		agendamento.setAnimal(animal);
		return new RedirectView("/agendamento/vet/selecionavet");
	}
	
	@RequestMapping(value = "/novobicho", method = RequestMethod.POST)
	public RedirectView novoAnimal(@ModelAttribute Dono dono, RedirectAttributes redirAtt) {
		redirAtt.addAttribute("dono", dono);
		return new RedirectView("/agendamento/cadastroanimal");
	}
	
}
