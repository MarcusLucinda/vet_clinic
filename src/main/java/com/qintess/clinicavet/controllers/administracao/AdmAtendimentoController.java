package com.qintess.clinicavet.controllers.administracao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qintess.clinicavet.models.Atendimento;
import com.qintess.clinicavet.models.Veterinario;
import com.qintess.clinicavet.services.AtendimentoService;
import com.qintess.clinicavet.services.VeterinarioService;

//Controller que lida com com a parte inicial do registro de atendimento

@Controller
@RequestMapping("/administracao/atendimento")
public class AdmAtendimentoController {

	@Autowired
	AtendimentoService atenServ;
	@Autowired
	VeterinarioService vetServ;
	
	@RequestMapping("/{vetId}")
	public String atendimentosVet(@PathVariable(name="vetId") Long vetId, Model model) {
		Veterinario veterinario = vetServ.buscaPorId(vetId);
		List<Atendimento> atendimentos = atenServ.buscaPorVet(veterinario);
		model.addAttribute("veterinario", veterinario);
		model.addAttribute("atendimentos", atendimentos);
		return "administracao/admListaAtendimentos";
	}
	
	@RequestMapping("/{vetId}/info/{atndId}")
	public String infoAtendimento(@PathVariable(name="vetId") Long vetId, @PathVariable(name="atndId") Long atndId,
			Model model) {
		Atendimento atendimento = atenServ.buscaPorId(atndId);
		model.addAttribute("atendimento", atendimento);
		return "administracao/admAtendimento";
	}
	
}
