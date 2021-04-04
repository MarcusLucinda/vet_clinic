package com.qintess.clinicavet.controllers.agendamento;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.qintess.clinicavet.models.Agendamento;
import com.qintess.clinicavet.models.Veterinario;
import com.qintess.clinicavet.services.VeterinarioService;

//Controller que trata da disponibilidade e seleção de veterinários durante um agendamento

@Controller
@SessionAttributes("ag")
@RequestMapping("agendamento/vet")
public class AgVetController {
	
	@Autowired
	VeterinarioService vetServ;
	
	
	@RequestMapping("")
	public String agenda(Model model, @ModelAttribute("ag") Agendamento agendamento) {
		model.addAttribute("veterinarios", vetServ.listaEspecialidade(agendamento.getAnimal().getClasse()));
		model.addAttribute("veterinario", new Veterinario());
		return "agendamento/selecionaMedico";
	}
	
	@RequestMapping(value="/selecionavet", method=RequestMethod.GET)
	public String selecionaVet(Model model, @ModelAttribute("ag") Agendamento agendamento) {
		model.addAttribute("veterinarios", vetServ.listaEspecialidade(agendamento.getAnimal().getClasse()));
		model.addAttribute("veterinario", new Veterinario());
		return "agendamento/selecionaMedico";
	}
	
	@RequestMapping(value="/escolhido", method=RequestMethod.POST)
	public String escolhido(@RequestParam Long id, @ModelAttribute("ag") Agendamento agendamento,
			Model model) {
		Veterinario vet = vetServ.buscaPorId(id);
		agendamento.setVeterinario(vet);
		return "redirect:/agendamento/agenda";
	}
	
	
}
