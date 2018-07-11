package br.com.cflima.semijoias.utils;

import java.util.List;

import org.eclipse.jetty.http.HttpStatus;

public class ResponseBuilder{
	
	protected ResponseDTO response;

	public ResponseBuilder() {
		response = new ResponseDTO();
	}
	
	public ResponseBuilder comSucesso() {
		this.response.setSucesso(true);
		this.response.setStatus(HttpStatus.OK_200);
		return this;
	}
	
	public ResponseBuilder comMensagem(String msg) {
		this.response.setMensagem(msg);
		return this;
	}
	
	public ResponseBuilder semSucesso()	{
		this.response.setSucesso(false);
		this.response.setStatus(HttpStatus.OK_200);
		return this;
	}

	public ResponseBuilder comList(List<?> valor) {
		this.response.setLista(valor);
		return this;
	}
	
	public ResponseBuilder comItem(Object item) {
		this.response.setItem(item);
		return this;
	}

	public ResponseDTO build() {
		return response;
	}
	
	
	
	
	

}
