package br.com.cflima.semijoias.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cflima.semijoias.service.IParticipanteService;
import br.com.cflima.semijoias.utils.ResponseDTO;

@Controller
public class ParticipanteController {
	
	@Autowired
	IParticipanteService serviceParticipante;
	
	@RequestMapping(value="usuarios", method= RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ResponseDTO listaParticipantes(){
		return serviceParticipante.list(); 
	}

}
