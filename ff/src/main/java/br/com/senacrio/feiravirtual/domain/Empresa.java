package br.com.senacrio.feiravirtual.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empresa_id")
	private Integer empresaId;
	@Column(name = "empresa_nome")
	private String empresaNome;
	@Column(name = "empresa_cnpj")
	private String empresaCnpj;
	@Column(name = "empresa_descricao" , columnDefinition = "TEXT")
	private String empresaDescricao;
	@Column(name = "empresa_cidade")
	private String empresaCidade;
	@Column(name = "empresa_estado")
	private String empresaEstado;
	@Column(name = "empresa_email")
	private String empresaEmail;
	@Column(name = "empresa_status")
	private int empresaStatus;
	@Column(name = "empresa_endereco")
	private String empresaEndereco;
	@Column(name = "empresa_bairro")
	private String empresaBairro;
	@Column(name = "empresa_site")
	private String empresaSite;
	@Column(name = "empresa_porte")
	private String empresaPorte;
	@Column(name = "empresa_num_funcionarios")
	private Integer empresaNumFuncionarios;
	@Column(name = "empresa_responsavel_legal")
	private String empresaResponsavelLegal;
	@Column(name = "empresa_razao_social")
	private String empresaRazaoSocial;

	public Integer getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Integer empresaId) {
		this.empresaId = empresaId;
	}

	public String getEmpresaNome() {
		return empresaNome;
	}

	public void setEmpresaNome(String empresaNome) {
		this.empresaNome = empresaNome;
	}

	public String getEmpresaCnpj() {
		return empresaCnpj;
	}

	public void setEmpresaCnpj(String empresaCnpj) {
		this.empresaCnpj = empresaCnpj;
	}

	public String getEmpresaDescricao() {
		return empresaDescricao;
	}

	public void setEmpresaDescricao(String empresaDescricao) {
		this.empresaDescricao = empresaDescricao;
	}

	public int getEmpresaStatus() {
		return empresaStatus;
	}

	public void setEmpresaStatus(int empresStatus) {
		this.empresaStatus = empresStatus;
	}

	public String getEmpresaCidade() {
		return empresaCidade;
	}

	public void setEmpresaCidade(String empresaCidade) {
		this.empresaCidade = empresaCidade;
	}

	public String getEmpresaEstado() {
		return empresaEstado;
	}

	public void setEmpresaEstado(String empresaEstado) {
		this.empresaEstado = empresaEstado;
	}

	public String getEmpresaEmail() {
		return empresaEmail;
	}

	public void setEmpresaEmail(String empresaEmail) {
		this.empresaEmail = empresaEmail;
	}

	public String getEmpresaEndereco() {
		return empresaEndereco;
	}

	public void setEmpresaEndereco(String empresaEndereco) {
		this.empresaEndereco = empresaEndereco;
	}

	public String getEmpresaBairro() {
		return empresaBairro;
	}

	public void setEmpresaBairro(String empresaBairro) {
		this.empresaBairro = empresaBairro;
	}

	public String getEmpresaSite() {
		return empresaSite;
	}

	public void setEmpresaSite(String empresaSite) {
		this.empresaSite = empresaSite;
	}

	public String getEmpresaPorte() {
		return empresaPorte;
	}

	public void setEmpresaPorte(String empresaPorte) {
		this.empresaPorte = empresaPorte;
	}

	public Integer getEmpresaNumFuncionarios() {
		return empresaNumFuncionarios;
	}

	public void setEmpresaNumFuncionarios(Integer empresaNumFuncionarios) {
		this.empresaNumFuncionarios = empresaNumFuncionarios;
	}

	public String getEmpresaResponsavelLegal() {
		return empresaResponsavelLegal;
	}

	public void setEmpresaResponsavelLegal(String empresaResponsavelLegal) {
		this.empresaResponsavelLegal = empresaResponsavelLegal;
	}

	public String getEmpresaRazaoSocial() {
		return empresaRazaoSocial;
	}

	public void setEmpresaRazaoSocial(String empresaRazaoSocial) {
		this.empresaRazaoSocial = empresaRazaoSocial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empresaId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (empresaId != other.empresaId)
			return false;
		return true;
	}
}