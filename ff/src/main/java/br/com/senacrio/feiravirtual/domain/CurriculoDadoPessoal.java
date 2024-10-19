package br.com.senacrio.feiravirtual.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "dado_pessoal")
public class CurriculoDadoPessoal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dado_pessoal_id")
	private Integer id;

	@Column(name = "dado_pessoal_nome_completo")
	@Length(max = 250, min = 5)
	@NotNull
	private String nomeCompleto;

	@Column(name = "dado_pessoal_email")
	@Length(max = 250)
	@NotNull
	private String email;

	@Column(name = "dado_pessoal_data_nascimento")
	@DateTimeFormat(iso = ISO.DATE)
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date dataNascimento;

	@Column(name = "dado_pessoal_estado_civil")
	@Length(max = 30)
	@NotNull
	private String estatoCivil;

	@Column(name = "dado_pessoal_numero_dependentes")
	@NotNull
	private int numeroDependentes;

	@Column(name = "dado_pessoal_celular")
	@Length(max = 25)
	@NotNull
	private String celular;

	@Column(name = "dado_pessoal_cep")
	@NotNull
	@Length(max = 45)
	private String cep;

	@Column(name = "dado_pessoal_logradouro")
	@NotNull
	private String logradouro;

	@Column(name = "dado_pessoal_numero_logradouro")
	@NotNull
	private int numeroLogradouro;

	@Column(name = "dado_pessoal_complemento_logradouro")
	@Length(max = 250)
	private String complementoLogradouro;

	@Column(name = "dado_pessoal_pretensao_salarial", columnDefinition="Decimal(10,2)")
	private Float pretensaoSalarial;

	@Column(name = "dado_pessoal_objetivo_profissional", columnDefinition = "LONGTEXT")
	private String objetivoProfissional;

	@Column(name = "dado_pessoal_deficiente")
	@NotNull
	private int deficiente;

	@OneToOne(mappedBy = "dadoPessoal")
	private Usuario usuario;

	@Column(name = "bairro_bairro_id")
	private Integer bairro = 1;

	@Column(name = "cidade_cidade_id")
	private Integer cidade = 1;

	@Column(name = "estado_estado_id")
	private Integer estado = 1;

	@Column(name = "sexo_id")
	private Integer sexo = 1;

	@ManyToOne
	@JoinColumn(name = "tipo_deficiencia_id")
	private Deficiencia deficiencia;

	public Deficiencia getDeficiencia() {
		return deficiencia;
	}

	public void setDeficiencia(Deficiencia deficiencia) {
		this.deficiencia = deficiencia;
	}
/*
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
*/
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEstatoCivil() {
		return estatoCivil;
	}

	public void setEstatoCivil(String estatoCivil) {
		this.estatoCivil = estatoCivil;
	}

	public int getNumeroDependentes() {
		return numeroDependentes;
	}

	public void setNumeroDependentes(int numeroDependentes) {
		this.numeroDependentes = numeroDependentes;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumeroLogradouro() {
		return numeroLogradouro;
	}

	public void setNumeroLogradouro(int numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}

	public String getComplementoLogradouro() {
		return complementoLogradouro;
	}

	public void setComplementoLogradouro(String complementoLogradouro) {
		this.complementoLogradouro = complementoLogradouro;
	}

	public Float getPretensaoSalarial() {
		return pretensaoSalarial;
	}

	public void setPretensaoSalarial(Float pretensaoSalarial) {
		this.pretensaoSalarial = pretensaoSalarial;
	}

	public String getObjetivoProfissional() {
		return objetivoProfissional;
	}

	public void setObjetivoProfissional(String objetivoProfissional) {
		this.objetivoProfissional = objetivoProfissional;
	}

	public int getDeficiente() {
		return deficiente;
	}

	public void setDeficiente(int deficiente) {
		this.deficiente = deficiente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getBairro() {
		return bairro;
	}

	public void setBairro(Integer bairro) {
		this.bairro = bairro;
	}

	public Integer getCidade() {
		return cidade;
	}

	public void setCidade(Integer cidade) {
		this.cidade = cidade;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getSexo() {
		return sexo;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

}