package br.com.cflima.semijoias.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cflima.semijoias.model.Participante;
import br.com.cflima.semijoias.repository.IParticipanteRepository;
import br.com.cflima.semijoias.service.IParticipanteService;
import br.com.cflima.semijoias.utils.ResponseBuilder;
import br.com.cflima.semijoias.utils.ResponseDTO;

@Service
public class ParticipanteServiceImpl implements IParticipanteService{

	@Autowired
	IParticipanteRepository participanteRepository;
	
	public ResponseDTO list() {
		try {
			List<Participante> list = (List<Participante>) participanteRepository.findAll();
			if(list != null && list.size() > 0)
				return new ResponseBuilder().comSucesso().comList(list).build();
			else
				return new ResponseBuilder().comSucesso().comMensagem("Não foi encontrado nenhum usuário cadastrado").build();
			
		} catch (Exception e) {
			return new ResponseBuilder().semSucesso().comMensagem("Erro ao buscar lista de usuários: "+e.getLocalizedMessage()).build();
		}
		
	}

}
