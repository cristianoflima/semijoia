package br.com.cflima.semijoias.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cflima.semijoias.model.Peca;
import br.com.cflima.semijoias.repository.IPecaRepository;
import br.com.cflima.semijoias.service.IPecaService;
import br.com.cflima.semijoias.utils.ResponseBuilder;
import br.com.cflima.semijoias.utils.ResponseDTO;

@Service
public class PecaServiceImpl implements IPecaService{
	
	@Autowired
	IPecaRepository pecaRepository;

	public ResponseDTO listAll() {
		try {
			List<Peca> list = (List<Peca>) pecaRepository.findAll();
			if(list != null && list.size() > 0)
				return new ResponseBuilder().comSucesso().comList(list).build();
			else
				return new ResponseBuilder().comSucesso().comMensagem("Nenhuma peça encontrada").build();
			
		} catch (Exception e) {
			return new ResponseBuilder().semSucesso().comMensagem("Erro ao buscar peça"+e.getLocalizedMessage()).build();
		}
		
	}

	public ResponseDTO save(Peca peca) {
		try {		
			if(peca.getMarca() == null)
				return new ResponseBuilder().comSucesso().comMensagem("Peça não salva, Marca não informada").build();
			else if(peca.getValor() == null) 
				return new ResponseBuilder().comSucesso().comMensagem("Peça não salva, valor não informado").build();
			
			//Consulta de já existe peça da mesma marca e valor cadastrados			
			Peca existente = pecaRepository.findPecaByValorEMarca(peca.getMarca().getId(), peca.getValor());			
//			
			if(existente != null)
				return new ResponseBuilder().comSucesso().comMensagem("Peça não salva, peça com valor e marca já cadastrados").build();
			
			Peca salva = pecaRepository.save(peca);
			if(salva != null)
				return new ResponseBuilder().comSucesso().comItem(salva).build();
			else
				return new ResponseBuilder().comSucesso().comMensagem("Peça não salva").build();			
		}catch (Exception e) {
			return new ResponseBuilder().semSucesso().comMensagem("Erro ao salvar peça"+e.getLocalizedMessage()).build();
		}		
	}

	public ResponseDTO delete(Long id) {
		try{
			pecaRepository.delete(id);
			return new ResponseBuilder().comSucesso().comMensagem("Peça excluida com sucesso").build();
			
		}catch (Exception e) {
			return new ResponseBuilder().semSucesso().comMensagem("Erro ao excluir peça: "+e.getLocalizedMessage()).build();
		}
	}

//	public ResponseDTO listaPecasByMarca(Long marcaId) {
//		try {
//			List<Peca> list = pecaRepository.findByMarcaId(marcaId);
//			if(list != null && list.size() > 0)
//				return new ResponseBuilder().comSucesso().comList(list).build(); 
//			else
//				return new ResponseBuilder().comSucesso().comMensagem("Nenhuma peça encontrada com marcaID = "+marcaId).build();
//			
//		} catch (Exception e) {
//			return new ResponseBuilder().semSucesso().comMensagem("Erro ao buscar peça por marcaID"+e.getLocalizedMessage()).build();
//		}
//	}


}
