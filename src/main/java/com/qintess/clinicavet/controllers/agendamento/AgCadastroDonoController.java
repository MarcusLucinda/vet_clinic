package com.qintess.clinicavet.controllers.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qintess.clinicavet.models.Dono;
import com.qintess.clinicavet.services.DonoService;

//Controller que trata de cadastro de novos clientes durante um agendamento

@Controller
@RequestMapping("agendamento/cadastrocliente")
public class AgCadastroDonoController {

	@Autowired
	DonoService donoServ;
	
	
	@RequestMapping("/{cpf}")
	public String cadastro(@PathVariable(name="cpf") Long cpf, Model model) {
		Dono novoDono = new Dono();
		novoDono.setCpf(cpf);
		model.addAttribute("novoDono", novoDono);
		return "agendamento/cadastroDono";
	}
	
	@RequestMapping(value = "/salva", method = RequestMethod.POST)
	public ModelAndView salvaNovoCLiente(@ModelAttribute Dono dono, RedirectAttributes redirAtt) {
		dono = donoServ.insere(dono);
		redirAtt.addFlashAttribute("dono", dono);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/agendamento/cadastroanimal");
		return mav;
	}
	
	
	
}
