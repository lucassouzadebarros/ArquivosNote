package br.com.senacrio.feiravirtual.domain;

import javax.persistence.*;

@Entity
@Table(name = "stand")
public class Stand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stand_id")
	private int standId;

	@Column(name = "stand_nome")
	private String standNome;

	@Column(name = "stand_link_apresentacao")
	private String standLinkApresentacao;

	@Column(name = "stand_link_chat")
	private String standLinkChat;

	@Column(name = "stand_status")
	private boolean standStatus;

	@Column(name = "stand_link_logomarca")
	private String standLinkLogomarca;

	@OneToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	public Stand() {
		super();
	}

	public Stand(int standId, String standNome, String standLinkApresentacao, String standLinkChat,
				 boolean standStatus, String standLinkLogomarca, Empresa empresa) {
		super();
		this.standId = standId;
		this.standNome = standNome;
		this.standLinkApresentacao = standLinkApresentacao;
		this.standLinkChat = standLinkChat;
		this.standStatus = standStatus;
		this.standLinkLogomarca = standLinkLogomarca;
		this.empresa = empresa;
	}

	public int getStandId() {
		return standId;
	}

	public void setStandId(int standId) {
		this.standId = standId;
	}

	public String getStandNome() {
		return standNome;
	}

	public void setStandNome(String stand_nome) {
		this.standNome = stand_nome;
	}

	public String getStandLinkApresentacao() {
		return standLinkApresentacao;
	}

	public void setStandLinkApresentacao(String stand_link_apresentacao) {
		this.standLinkApresentacao = stand_link_apresentacao;
	}

	public String getStandLinkChat() {
		return standLinkChat;
	}

	public void setStandLinkChat(String stand_link_chat) {
		this.standLinkChat = stand_link_chat;
	}

	public boolean getStandStatus() {
		return standStatus;
	}

	public void setStandStatus(boolean stand_status) {
		this.standStatus = stand_status;
	}

	public String getStandLinkLogomarca() {
		return standLinkLogomarca;
	}

	public void setStandLinkLogomarca(String stand_link_logomarca) {

		this.standLinkLogomarca = stand_link_logomarca;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + standId;
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
		Stand other = (Stand) obj;
		if (standId != other.standId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stand{" +
				"standId=" + standId +
				", standNome='" + standNome + '\'' +
				", standLinkApresentacao='" + standLinkApresentacao + '\'' +
				", standLinkChat='" + standLinkChat + '\'' +
				", standStatus='" + standStatus + '\'' +
				", standLinkLogomarca='" + standLinkLogomarca + '\'' +
				", empresa=" + empresa +
				'}';
	}
}
