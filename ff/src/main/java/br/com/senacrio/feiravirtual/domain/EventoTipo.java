package br.com.senacrio.feiravirtual.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evento_tipo")
public class EventoTipo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3756547143893531435L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "evento_tipo_id")
	private Integer id;
	
	@Column(name = "evento_tipo_descricao", nullable = false)
	private String eventoTipoDescricao;
	
	@Column(name = "evento_tipo_status", nullable = false)
	private Integer eventoTipoStatus;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getEventoTipoDescricao() {
		return eventoTipoDescricao;
	}

	public void setEventoTipoDescricao(String eventoTipoDescricao) {
		this.eventoTipoDescricao = eventoTipoDescricao;
	}

	public Integer getEventoTipoStatus() {
		return eventoTipoStatus;
	}

	public void setEventoTipoStatus(Integer eventoTipoStatus) {
		this.eventoTipoStatus = eventoTipoStatus;
	}
}
