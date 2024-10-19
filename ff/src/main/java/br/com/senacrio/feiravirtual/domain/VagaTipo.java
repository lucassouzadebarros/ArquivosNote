package br.com.senacrio.feiravirtual.domain;

import javax.persistence.*;

@Entity
@Table(name = "vaga_tipo")
public class VagaTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaga_tipo_id")
    private Integer id;
    @Column(name = "vaga_tipo_descricao")
    private String descricao;
    @Column(name = "vaga_tipo_status")
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
