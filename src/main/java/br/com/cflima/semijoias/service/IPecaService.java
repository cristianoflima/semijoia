package br.com.cflima.semijoias.service;

import br.com.cflima.semijoias.model.Peca;
import br.com.cflima.semijoias.utils.ResponseDTO;

public interface IPecaService {	
	
	public ResponseDTO listAll();

	public ResponseDTO save(Peca peca);

	public ResponseDTO delete(Long valueOf);
	
//	public ResponseDTO listaPecasByMarca(Long marcaId);

}
