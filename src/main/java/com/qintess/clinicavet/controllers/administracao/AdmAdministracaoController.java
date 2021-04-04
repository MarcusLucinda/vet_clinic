package com.qintess.clinicavet.controllers.administracao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller da página inicial da administração

@Controller
@RequestMapping("/administracao")
public class AdmAdministracaoController {

	@RequestMapping("")
	public String opcoes() {
		return "administracao/administracao";
	}
}
