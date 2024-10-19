package br.com.senacrio.feiravirtual.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "segmento")
public class Segmento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "segmento_id")
    private Integer id;
    @Column(name = "segmento_descricao")
    private String descricao;
    @Column(name = "segmento_status")
    private Integer status;

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
}
