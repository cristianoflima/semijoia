package br.com.cflima.semijoias.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Marca implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2741635106095489488L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	@OneToMany(targetEntity=Peca.class, mappedBy = "marca")
	@JsonManagedReference
	private List<Peca> pecas;
	
	
	public Marca() {}
	
	
	public Marca(String descricao) {
		this.descricao = descricao;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public List<Peca> getPecas() {
		return pecas;
	}
	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}
	
	
	
	
}
