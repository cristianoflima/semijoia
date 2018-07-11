package br.com.cflima.semijoias.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
/*	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String entrar() {
		return "login";
	}*/

}
