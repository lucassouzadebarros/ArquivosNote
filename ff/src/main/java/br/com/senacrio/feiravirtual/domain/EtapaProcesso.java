package br.com.senacrio.feiravirtual.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "etapa_processo")
public class EtapaProcesso implements Serializable {

	private static final long serialVersionUID = -7867138759861781253L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "etapa_processo_id")
	private Integer etapaProcessoId;

	@Column(name = "etapa_processo_descricao", length = 250)
	private String etapaProcessoDescricao;

	@Column(name = "etapa_processo_status", length = 11)
	private int etapaProcessoStatus;

	/*
	@OneToMany(mappedBy = "etapaProcesso")
	@Cascade(CascadeType.ALL)
	private List<Candidatura> candidaturas;
	*/
	public EtapaProcesso() {

	}

	public EtapaProcesso(Integer etapaProcessoId, String etapaProcessoDescricao, int etapaProcessoStatus,
			List<Candidatura> candidaturas) {
		super();
		this.etapaProcessoId = etapaProcessoId;
		this.etapaProcessoDescricao = etapaProcessoDescricao;
		this.etapaProcessoStatus = etapaProcessoStatus;
		//this.candidaturas = candidaturas;
	}

	public Integer getEtapaProcessoId() {
		return etapaProcessoId;
	}

	public void setEtapaProcessoId(Integer etapaProcessoId) {
		this.etapaProcessoId = etapaProcessoId;
	}

	public String getEtapaProcessoDescricao() {
		return etapaProcessoDescricao;
	}

	public void setEtapaProcessoDescricao(String etapaProcessoDescricao) {
		this.etapaProcessoDescricao = etapaProcessoDescricao;
	}

	public int getEtapaProcessoStatus() {
		return etapaProcessoStatus;
	}

	public void setEtapaProcessoStatus(int etapaProcessoStatus) {
		this.etapaProcessoStatus = etapaProcessoStatus;
	}
/*
	public List<Candidatura> getCandidaturas() {
		return candidaturas;
	}

	public void setCandidaturas(List<Candidatura> candidaturas) {
		this.candidaturas = candidaturas;
	}
*/
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}