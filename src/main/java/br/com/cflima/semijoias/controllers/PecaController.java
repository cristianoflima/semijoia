package br.com.cflima.semijoias.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cflima.semijoias.model.Peca;
import br.com.cflima.semijoias.service.IPecaService;
import br.com.cflima.semijoias.utils.ResponseDTO;

@Controller
public class PecaController {
	
	@Autowired
	IPecaService service;
	
	@RequestMapping(value="pecas", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ResponseDTO listaPedidos() {
		return service.listAll();
	};
	
//	@RequestMapping(value="pecas/marca/{marcaId}", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public ResponseDTO buscarPorMarca(@PathVariable String strMarcaId) {
//		return service.listaPecasByMarca(Long.valueOf(strMarcaId));
//	}
	
	@RequestMapping(value="pecas", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseDTO salvar(@RequestBody Peca peca) {
		return service.save(peca);
	}
	
	
	
	@RequestMapping(value="pecas/{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseDTO delete(@PathVariable String id) {
		return service.delete(Long.valueOf(id));
	}

}
