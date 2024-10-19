package br.com.senacrio.feiravirtual.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "link_externo")
public class CurriculoLinkExterno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "link_externo_id")
	private Integer id;

	@Column(name = "link_externo_valor", columnDefinition = "LONGTEXT")
	private String valor;

	@Column(name = "link_esterno_status")
	private Integer status;

	@OneToMany
	@JoinColumn(name = "link_id")
	private List<CurriculoLink> links;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<CurriculoLink> getLinks() {
		return links;
	}

	public void setLinks(List<CurriculoLink> links) {
		this.links = links;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}