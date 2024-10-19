package br.com.senacrio.feiravirtual.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.senacrio.feiravirtual.enuns.CurriculoStatus;

@Entity
@Table(name = "curriculo")
public class Curriculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "curriculo_id")
	private Integer id;

	@Column(name = "curriculo_nome")
	private String nome;

	@Column(name = "curriculo_mini", columnDefinition = "LONGTEXT")
	private String mini;

	@Column(name = "curriculo_status")
	private Integer status = CurriculoStatus.HABILITADO.getValor();

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;








	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMini() {
		return mini;
	}

	public void setMini(String mini) {
		this.mini = mini;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}