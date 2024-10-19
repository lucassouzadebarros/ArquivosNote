package br.com.senacrio.feiravirtual.domain;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "vaga")
public class Vaga implements Serializable {

	private static final long serialVersionUID = 7990505509176791810L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vaga_id")
	private Integer id;

	@Column(name = "vaga_senac")
	private int senac;

	@Column(name = "vaga_codigo_senac")
	private String codigoSenac;

	@Column(name = "vaga_url_vaga")
	private String urlVaga;

	@Column(name = "vaga_cargo")
	private String cargo;

	@Column(name = "vaga_descricao")
	private String descricao;

	@Column(name = "vaga_quantidade")
	private int quantidade;

	@Column(name = "vaga_remuneracao")
	private double remuneracao;

	@Type(type = "text")
	@Column(name = "vaga_requisitos")
	private String requisitos;

	@Type(type = "text")
	@Column(name = "vaga_atividades_principais")
	private String atividadesPrincipais;

	@Type(type = "text")
	@Column(name = "vaga_beneficios")
	private String beneficios;

	@Type(type = "text")
	@Column(name = "vaga_observacoes")
	private String observacoes;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@Column(name = "vaga_disponibilidade_inicio")
	private LocalDateTime disponibilidadeInicio;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@Column(name = "vaga_disponibilidade_fim")
	private LocalDateTime disponibilidadeFim;

	@Column(name = "vaga_status")
	private String status;

	@ManyToOne
	@JoinColumn(name = "area_atuacao_id", nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private AreaAtuacao areaAtuacao;

	@OneToOne
	@JoinColumn(name = "bairro_id", nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Bairro bairro;

	@OneToOne
	@JoinColumn(name = "cidade_id", nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Cidade cidade;

	@ManyToOne
	@JoinColumn(name = "empresa_id", nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Empresa empresa;

	@OneToOne
	@JoinColumn(name = "estado_id", nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Estado estado;

	@OneToOne
	@JoinColumn(name = "segmento_id", nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Segmento segmento;

	@OneToOne
	@JoinColumn(name = "vaga_tipo_id", nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private VagaTipo vagaTipo;

	@OneToMany(mappedBy = "vaga")
	@Cascade(CascadeType.ALL)
	@JsonProperty(access = Access.READ_ONLY)
	private List<Candidatura> candidaturas;

	public Vaga() {

	}

	public Vaga(Integer id, int senac, String codigoSenac, String urlVaga, String cargo, String descricao,
				int quantidade, double remuneracao, String requisitos, String atividadesPrincipais, String beneficios,
				String observacoes, LocalDateTime disponibilidadeInicio, LocalDateTime disponibilidadeFim, String status,
				AreaAtuacao areaAtuacao, Bairro bairro, Cidade cidade, Empresa empresa, Estado estado, Segmento segmento,
				VagaTipo vagaTipo, List<Candidatura> candidaturas) {
		super();
		this.id = id;
		this.senac = senac;
		this.codigoSenac = codigoSenac;
		this.urlVaga = urlVaga;
		this.cargo = cargo;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.remuneracao = remuneracao;
		this.requisitos = requisitos;
		this.atividadesPrincipais = atividadesPrincipais;
		this.beneficios = beneficios;
		this.observacoes = observacoes;
		this.disponibilidadeInicio = disponibilidadeInicio;
		this.disponibilidadeFim = disponibilidadeFim;
		this.status = status;
		this.areaAtuacao = areaAtuacao;
		this.bairro = bairro;
		this.cidade = cidade;
		this.empresa = empresa;
		this.estado = estado;
		this.segmento = segmento;
		this.vagaTipo = vagaTipo;
		this.candidaturas = candidaturas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getSenac() {
		return senac;
	}

	public void setSenac(int senac) {
		this.senac = senac;
	}

	public String getCodigoSenac() {
		return codigoSenac;
	}

	public void setCodigoSenac(String codigoSenac) {
		this.codigoSenac = codigoSenac;
	}

	public String getUrlVaga() {
		return urlVaga;
	}

	public void setUrlVaga(String urlVaga) {
		this.urlVaga = urlVaga;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getRemuneracao() {
		return remuneracao;
	}

	public void setRemuneracao(double remuneracao) {
		this.remuneracao = remuneracao;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public String getAtividadesPrincipais() {
		return atividadesPrincipais;
	}

	public void setAtividadesPrincipais(String atividadesPrincipais) {
		this.atividadesPrincipais = atividadesPrincipais;
	}

	public String getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public LocalDateTime getDisponibilidadeInicio() {
		return disponibilidadeInicio;
	}

	public void setDisponibilidadeInicio(LocalDateTime disponibilidadeInicio) {
		this.disponibilidadeInicio = disponibilidadeInicio;
	}

	public LocalDateTime getDisponibilidadeFim() {
		return disponibilidadeFim;
	}

	public void setDisponibilidadeFim(LocalDateTime disponibilidadeFim) {
		this.disponibilidadeFim = disponibilidadeFim;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AreaAtuacao getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(AreaAtuacao areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Segmento getSegmento() {
		return segmento;
	}

	public void setSegmento(Segmento segmento) {
		this.segmento = segmento;
	}

	public VagaTipo getVagaTipo() {
		return vagaTipo;
	}

	public void setVagaTipo(VagaTipo vagaTipo) {
		this.vagaTipo = vagaTipo;
	}

	public List<Candidatura> getCandidaturas() {
		return candidaturas;
	}

	public void setCandidaturas(List<Candidatura> candidaturas) {
		this.candidaturas = candidaturas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}