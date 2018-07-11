package br.com.cflima.semijoias.service;

import br.com.cflima.semijoias.model.Marca;
import br.com.cflima.semijoias.utils.ResponseDTO;

public interface IMarcaService {

	public ResponseDTO list();

	public ResponseDTO save(Marca marca);
	
	public ResponseDTO delete(Long marca);
}
