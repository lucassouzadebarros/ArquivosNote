package br.com.senacrio.feiravirtual.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "evento")
public class Evento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7037916308692461564L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "evento_id")
    private Integer id;

    @Column(name = "evento_titulo")
    private String eventoTitulo;
    
    @OneToOne
    @JoinColumn(name = "evento_tipo_id")
    private EventoTipo eventoTipo;
    
    @Column(name = "evento_link_evento")
    private String eventoLink;

    @Column(name = "evento_link_banner")
    private String eventoLinkBanner;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    @Column(name = "evento_data_inicio")
    private LocalDateTime eventoDataInicio;

    @DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "evento_data_fim")
	private LocalDateTime eventoDataFim;

    @Column(name = "evento_vagas")
    private int eventoVagas;
    
    @Column(name = "evento_status")
    private Integer eventoStatus;
    
    @ManyToOne
    @JoinColumn(name = "stand_id")
    private Stand stand;
    
    @OneToMany(targetEntity=Palestrante.class, mappedBy = "resp_id")
   	private List<Responsavel> palestrante;
    
    public List<Responsavel> getPalestrante() {
		return palestrante;
	}

	public void setPalestrante(List<Responsavel> palestrante) {
		this.palestrante = palestrante;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEventoTitulo() {
		return eventoTitulo;
	}

	public void setEventoTitulo(String eventoTitulo) {
		this.eventoTitulo = eventoTitulo;
	}

	public EventoTipo getEventoTipo() {
		return eventoTipo;
	}

	public void setEventoTipo(EventoTipo eventoTipo) {
		this.eventoTipo = eventoTipo;
	}

	public String getEventoLink() {
		return eventoLink;
	}

	public void setEventoLink(String eventoLink) {
		this.eventoLink = eventoLink;
	}

	public LocalDateTime getEventoDataInicio() {
		return eventoDataInicio;
	}

	public void setEventoDataInicio(LocalDateTime eventoDataInicio) {
		this.eventoDataInicio = eventoDataInicio;
	}

	public LocalDateTime getEventoDataFim() { return eventoDataFim; }

	public void setEventoDataFim(LocalDateTime eventoDataFim) { this.eventoDataFim = eventoDataFim; }

	public String getEventoLinkBanner() {
		return eventoLinkBanner;
	}

	public void setEventoLinkBanner(String eventoLinkBanner) {
		this.eventoLinkBanner = eventoLinkBanner;
	}

	public int getEventoVagas() {
		return eventoVagas;
	}

	public void setEventoVagas(int eventoVagas) {
		this.eventoVagas = eventoVagas;
	}

	public Integer getEventoStatus() {
		return eventoStatus;
	}

	public void setEventoStatus(Integer eventoStatus) {
		this.eventoStatus = eventoStatus;
	}

	public Stand getStand() {
		return stand;
	}

	public void setStand(Stand stand) {
		this.stand = stand;
	}
	
	@Override
	public String toString() {
		return "EventoDomain{" +
				"id=" + id +
				", eventoTitulo='" + eventoTitulo + '\'' +
				'}';
	}
}
