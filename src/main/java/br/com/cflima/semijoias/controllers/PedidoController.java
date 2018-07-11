package br.com.cflima.semijoias.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PedidoController {
	
	@RequestMapping("/listaPedidos")
	public String listaPedidos() {
		return "listaPedidos";
	}

}
