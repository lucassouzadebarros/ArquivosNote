package br.com.senacrio.feiravirtual.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "formacao_academica")
public class CurriculoFormacaoAcademica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "formacao_academica_id")
	private Integer id;

	@Column(name = "formacao_academica_curso")
	@NotNull
	@Length(max = 250)
	private String curso;

	@Column(name = "formacao_academica_instituicao")
	@NotNull
	@Length(max = 250)
	private String instituicao;

	@Column(name = "formacao_academica_fim")
	private Date dataFim;

	@Column(name = "formacao_academica_situacao")
	@Length(max = 45)
	private String situacao;

	@Column(name = "formacao_academica_status")
	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "nivel_instrucao_id")
	private CurriculoNivelInstrucao nivelInstrucao;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public CurriculoNivelInstrucao getNivelInstrucao() {
		return nivelInstrucao;
	}

	public void setNivelInstrucao(CurriculoNivelInstrucao nivelInstrucao) {
		this.nivelInstrucao = nivelInstrucao;
	}

}