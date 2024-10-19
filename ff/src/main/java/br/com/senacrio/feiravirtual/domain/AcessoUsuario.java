package br.com.senacrio.feiravirtual.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Embeddable
@Table(name = "acesso_usuario")
public class AcessoUsuario implements Serializable {

    private static final long serialVersionUID = 4246184099083400358L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acesso_usuario_id")
    private Integer id;

    @Column(name = "acesso_usuario_data")
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "stand_id")
    private Stand stand;

    public AcessoUsuario() {

    }

    public AcessoUsuario(LocalDateTime data, Usuario usuario, Stand stand) {
        this.data = data;
        this.usuario = usuario;
        this.stand = stand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }
}