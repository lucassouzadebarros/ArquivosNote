package br.com.senacrio.feiravirtual.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Palestrante")
public class Palestrante implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "palestrante_id")
	private int Id;
	
	
	@ManyToOne
	@JoinColumn(name = "evento_id")
	Evento evento;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Responsavel resp_id;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Responsavel getResp_id() {
		return resp_id;
	}

	public void setResp_id(Responsavel resp_id) {
		this.resp_id = resp_id;
	}
	
	
	
	

}
