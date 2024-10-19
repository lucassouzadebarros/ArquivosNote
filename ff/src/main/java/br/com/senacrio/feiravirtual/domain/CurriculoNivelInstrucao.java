package br.com.senacrio.feiravirtual.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "nivel_instrucao")
public class CurriculoNivelInstrucao {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nivel_instrucao_id")
	Integer id;

	@Column(name = "nivel_instrucao_descricao")
//	@NotNull
	@Length(max = 250)
	String descricao;

	@Column(name = "nivel_instrucao_status")
//	@NotNull
			Integer status = 1;

	@JsonIgnore
	@OneToMany(mappedBy = "nivelInstrucao", cascade = CascadeType.ALL)
	List<CurriculoFormacaoAcademica> curriculoFormacaoAcademica;

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

	public List<CurriculoFormacaoAcademica> getCurriculoFormacaoAcademica() {
		return curriculoFormacaoAcademica;
	}

	public void setCurriculoFormacaoAcademica(List<CurriculoFormacaoAcademica> curriculoFormacaoAcademica) {
		this.curriculoFormacaoAcademica = curriculoFormacaoAcademica;
	}

}