package br.com.cflima.semijoias.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cflima.semijoias.model.Marca;
import br.com.cflima.semijoias.service.IMarcaService;
import br.com.cflima.semijoias.utils.ResponseDTO;

/**
 * Classe controller para manipulação de dados
 * usando IMarcaService e metodos com retornos ResponseDTO
 *
 * @author Cristiano Fernandes de Lima
 *
 */

@Controller
public class MarcaController {
	
	@Autowired
	IMarcaService marcaService;
	
		
	@RequestMapping(value="marcas", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseDTO listaMarcas(){
		return marcaService.list();
	}
	
	@RequestMapping(value="marcas", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseDTO save(@RequestBody Marca marca) {
		return marcaService.save(marca);
	}
	
	@RequestMapping(value="marcas/{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseDTO delete(@PathVariable String id) {
		return marcaService.delete(Long.valueOf(id));
	}
	

}
