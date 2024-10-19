package br.com.senacrio.feiravirtual.domain;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "politica_lgpd")
public class PoliticaLgpd implements Serializable {

	private static final long serialVersionUID = -93222103487418794L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "politica_lgpd_id")
	private Integer id;

	@Column(name = "politica_lgpd_descricao")
	@Type(type = "text")
	private String descricao;

	@Column(name = "politica_lgpd_versao")
	private String versao;

	@Column(name = "politica_lgpd_status")
	private int status;

	public PoliticaLgpd() {

	}

	public PoliticaLgpd(Integer id, String descricao, String versao, int status) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.versao = versao;
		this.status = status;
	}

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

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}