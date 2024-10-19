package br.com.senacrio.feiravirtual.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "evento_usuario")
public class EventoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evento_usuario_id")
    private Integer id;
    @Column(name = "evento_usuario_data_registro")
    private Date dataRegistro;
    @Column(name = "evento_usuario_link_certificado")
    private String linkCertificado;
    @Column(name = "evento_usuario_status")
    private Integer status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "evento_id")
    private Evento evento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getLinkCertificado() {
        return linkCertificado;
    }

    public void setLinkCertificado(String linkCertificado) {
        this.linkCertificado = linkCertificado;
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

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
