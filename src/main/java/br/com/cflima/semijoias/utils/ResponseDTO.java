package br.com.cflima.semijoias.utils;

import java.util.List;

/**
 * 
 * @author Cristiano Fernandes de Lima
 * @description Classe de retorno genérica, 
 * todo serviço retorna um DTO
 * 
 * Criação: 24/12/2017
 */
public class ResponseDTO{
	
	private String mensagem;
	private int status;
	private List<?> lista;
	private boolean sucesso;
	private Object item;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<?> getLista() {
		return lista;
	}

	public void setLista(List<?> lista) {
		this.lista = lista;
	}

	public boolean isSucesso() {
		return sucesso;
	}

	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}

	public Object getItem() {
		return item;
	}

	public void setItem(Object item) {
		this.item = item;
	}
	
	
	
	

}
