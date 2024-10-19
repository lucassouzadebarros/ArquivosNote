package br.com.senacrio.feiravirtual.domain;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import br.com.senacrio.feiravirtual.domain.Usuario;
import br.com.senacrio.feiravirtual.domain.Vaga;
import br.com.senacrio.feiravirtual.domain.Curriculo;
import br.com.senacrio.feiravirtual.domain.EtapaProcesso;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "candidatura")
public class Candidatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidatura_id")
    private Integer id;
    @Column(name = "candidatura_data")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime data;
    @Column(name = "candidatura_status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "vaga_id", nullable = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    private Vaga vaga;

    @OneToOne
    @JoinColumn(name = "curriculo_id")
    private Curriculo curriculo;

    @OneToOne
    @JoinColumn(name = "etapa_processo_id")
    private EtapaProcesso etapaProcesso;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
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

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Curriculo getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(Curriculo curriculo) {
        this.curriculo = curriculo;
    }

    public EtapaProcesso getEtapaProcesso() {
        return etapaProcesso;
    }

    public void setEtapaProcesso(EtapaProcesso etapaProcesso) {
        this.etapaProcesso = etapaProcesso;
    }

}
