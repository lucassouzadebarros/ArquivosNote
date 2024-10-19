package br.com.senacrio.feiravirtual.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "informacao_adicional_tipo")
public class CurriculoInformacaoAdicionalTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "informacao_adicional_tipo_id")
    private Integer id;

    @Column(name = "informacao_adicional_tipo_descricao")
    @Length(max = 250)
    private String descricao;

    @OneToMany(mappedBy = "tipo")
    private List<CurriculoInformacaoAdicional> informacoesAdicionais;

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

    public List<CurriculoInformacaoAdicional> getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setInformacoesAdicionais(List<CurriculoInformacaoAdicional> informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

}