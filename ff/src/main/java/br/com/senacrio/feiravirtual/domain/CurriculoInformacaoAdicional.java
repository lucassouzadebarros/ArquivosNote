package br.com.senacrio.feiravirtual.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "informacao_adicional")
public class CurriculoInformacaoAdicional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "informacao_adicional_id")
	private Integer id;

	@Column(name = "informacao_adicional_descricao", columnDefinition = "LONGTEXT")
	private String descricao;

	@Column(name = "informacao_adicional_status")
	private Integer status;

	@ManyToOne
	@JoinColumn(name = "tipo_informacao_adicional_tipo_id")
	private CurriculoInformacaoAdicionalTipo tipo;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public CurriculoInformacaoAdicionalTipo getTipo() {
		return tipo;
	}

	public void setTipo(CurriculoInformacaoAdicionalTipo tipo) {
		this.tipo = tipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}