package br.com.senacrio.feiravirtual.domain;

import javax.persistence.*;

@Entity
@Table(name = "responsavel")
public class Responsavel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "responsavel_id")
	private int responsavelId;

	@Column(name = "responsavel_nome_completo")
	private String responsavelNomeCompleto;

	@Column(name = "responsavel_status")
	private Integer responsavelStatus;

	@Column(name = "responsavel_usuario")
	private String responsavelUsuario;

	@Column(name = "responsavel_senha")
	private String responsavelSenha;

	@Column(name = "responsavel_email")
	private String responsavelEmail;

	@Column(name = "responsavel_telefone")
	private String responsavelTelefone;

	@OneToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Responsavel() {
		super();
	}

	public Responsavel(int responsavelId, String responsavelNomeCompleto, Integer responsavelStatus, Empresa empresa,
					   String responsavelUsuario, String responsavelSenha, String responsavelEmail,
					   String responsavelTelefone) {
		super();
		this.responsavelId = responsavelId;
		this.responsavelNomeCompleto = responsavelNomeCompleto;
		this.responsavelStatus = responsavelStatus;
		this.empresa = empresa;
		this.responsavelUsuario = responsavelUsuario;
		this.responsavelSenha = responsavelSenha;
		this.responsavelEmail = responsavelEmail;
		this.responsavelTelefone = responsavelTelefone;
	}

	public int getResponsavelId() {
		return responsavelId;
	}

	public void setResponsavelId(int responsavel_id) {
		this.responsavelId = responsavel_id;
	}

	public String getResponsavelNomeCompleto() {
		return responsavelNomeCompleto;
	}

	public void setResponsavelNomeCompleto(String nome_completo) {
		this.responsavelNomeCompleto = nome_completo;
	}

	public Integer getResponsavelStatus() {
		return responsavelStatus;
	}

	public void setResponsavelStatus(Integer responsavel_status) {
		this.responsavelStatus = responsavel_status;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getResponsavelUsuario() {
		return responsavelUsuario;
	}

	public void setResponsavelUsuario(String responsavel_usuario) {
		this.responsavelUsuario = responsavel_usuario;
	}

	public String getResponsavelSenha() {
		return responsavelSenha;
	}

	public void setResponsavelSenha(String responavel_senha) {
		this.responsavelSenha = responavel_senha;
	}

	public String getResponsavelEmail() {
		return responsavelEmail;
	}

	public void setResponsavelEmail(String responsavel_email) {
		this.responsavelEmail = responsavel_email;
	}

	public String getResponsavelTelefone() {
		return responsavelTelefone;
	}

	public void setResponsavelTelefone(String responsavel_telefone) {
		this.responsavelTelefone = responsavel_telefone;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Responsavel{" +
				"responsavelId=" + responsavelId +
				", nomeCompleto='" + responsavelNomeCompleto + '\'' +
				", responsavelStatus=" + responsavelStatus +
				", empresa=" + empresa +
				", responsavelUsuario='" + responsavelUsuario + '\'' +
				", responsavelSenha='" + responsavelSenha + '\'' +
				", responsavelEmail='" + responsavelEmail + '\'' +
				", responsavelTelefone='" + responsavelTelefone + '\'' +
				'}';
	}
}
