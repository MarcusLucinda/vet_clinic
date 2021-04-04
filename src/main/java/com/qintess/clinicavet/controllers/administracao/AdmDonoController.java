package com.qintess.clinicavet.controllers.administracao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.qintess.clinicavet.models.Animal;
import com.qintess.clinicavet.models.Dono;
import com.qintess.clinicavet.services.DonoService;

//Controller que lida com as partes relacionadas ao cliente na administração

@Controller
@RequestMapping("administracao/cliente")
public class AdmDonoController {
	
	@Autowired
	DonoService donoServ;
	
	@RequestMapping("")
	public String agendamentoHome(Model model) {
		List<Dono> clientes = donoServ.listaTodos();
		model.addAttribute("vazio", new Dono());
		model.addAttribute("clientes", clientes);
		return "administracao/admDono";
	}
	
	
	@RequestMapping("/cadastro/{cpf}")
	public String cadastro(@PathVariable(name="cpf") Long cpf, Model model) {
		Dono novoDono = new Dono();
		novoDono.setCpf(cpf);
		model.addAttribute("novoDono", novoDono);
		return "administracao/admCadastroDono";
	}
	
	@RequestMapping(value="/busca", method=RequestMethod.POST)
	public String buscaDono(Model model, @RequestParam("cpfDono") String cpfs) {
		Long cpf = Long.parseLong(cpfs);
		Dono dono = donoServ.buscaId(cpf);
		if(dono == null) {
			return "redirect:/administracao/cliente/cadastro/"+cpf;
		}else {
			return "redirect:/administracao/cliente/"+cpf;
		}
	}
	
	@RequestMapping(value = "/altera", method = RequestMethod.POST)
	public String alteraDono(@ModelAttribute Dono dono, Model model) {
		model.addAttribute("novoDono", dono);
		return "administracao/admAlteraDono";
	}
	
	@RequestMapping(value = "/alterado", method = RequestMethod.POST)
	public String redirAlterado(@ModelAttribute Dono dono, RedirectAttributes redirAtt) {
		dono = donoServ.insere(dono);
		return "redirect:/administracao/cliente/"+dono.getCpf();
	}
	
	
	@RequestMapping("/{cpf}")
	public String carregaAlterar(@PathVariable(name="cpf") Long cpf, Model model) {
		Dono dono = donoServ.buscaId(cpf);
		model.addAttribute("dono", dono);
		model.addAttribute("animais", donoServ.listaAnimais(dono));
		model.addAttribute("animal", new Animal());
		return "administracao/admDono";
	}
	
	@RequestMapping(value = "/salva", method = RequestMethod.POST)
	public ModelAndView salvaNovoCLiente(@ModelAttribute Dono dono, RedirectAttributes redirAtt) {
		dono = donoServ.insere(dono);
		redirAtt.addFlashAttribute("dono", dono);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/administracao/animal");
		return mav;
	}
	
	@RequestMapping(value = "/novobicho", method = RequestMethod.POST)
	public RedirectView novoAnimal(@ModelAttribute Dono dono, RedirectAttributes redirAtt) {
		redirAtt.addAttribute("dono", dono);
		return new RedirectView("/administracao/animal");
	}

}
