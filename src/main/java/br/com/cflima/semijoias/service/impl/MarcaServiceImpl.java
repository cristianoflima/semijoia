package br.com.cflima.semijoias.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cflima.semijoias.model.Marca;
import br.com.cflima.semijoias.repository.IMarcaRepository;
import br.com.cflima.semijoias.service.IMarcaService;
import br.com.cflima.semijoias.utils.ResponseBuilder;
import br.com.cflima.semijoias.utils.ResponseDTO;

@Service
public class MarcaServiceImpl implements IMarcaService{
	
	@Autowired
	IMarcaRepository marcaRepository;

	public ResponseDTO list() {
		try {
			List<Marca> list = (List<Marca>) marcaRepository.findAll();
			if(list !=null && list.size() > 0)
				return new ResponseBuilder().comSucesso().comList(list).build();
			else
				return new ResponseBuilder().comSucesso().comMensagem("Não foi encontrada nenhuma marca cadastrada.").build();
		}catch(Exception e) {
			return new ResponseBuilder().semSucesso().comMensagem("Erro ao buscar lista de marcas: "+e.getLocalizedMessage()).build();
		}
	}

	public ResponseDTO save(Marca marca) {
		try {
			
			Marca salva = marcaRepository.save(marca);
			if(salva != null)
				return new ResponseBuilder().comSucesso().comItem(salva).build();
			else
				return new ResponseBuilder().comSucesso().comMensagem("Marca não foi salva").build();
		}catch(Exception e) {
			return new ResponseBuilder().semSucesso().comMensagem("Erro ao salvar marca: "+e.getLocalizedMessage()).build();
		}
		
		
	}
	
	public ResponseDTO delete(Long id) {
		try {
			 marcaRepository.delete(id);
			 return new ResponseBuilder().comSucesso().comMensagem("Marca ID:"+id+" excluída com sucesso.").build();
		}catch (Exception e) {
			return new ResponseBuilder().semSucesso().comMensagem("Erro ao excluir marca: "+e.getLocalizedMessage()).build();
		}
	}
	

}
