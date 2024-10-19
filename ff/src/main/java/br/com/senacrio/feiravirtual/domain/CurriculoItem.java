package br.com.senacrio.feiravirtual.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "curriculo_item")
public class CurriculoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curriculo_item_id")
    private Integer id;

    @OneToMany
    @JoinColumn(name = "curriculo_id")
    private List<Curriculo> curriculos;

    @OneToMany
    @JoinColumn(name = "link_externo_id")
    private List<CurriculoLinkExterno> linksExternos;

    @OneToMany
    @JoinColumn(name = "informacao_adicional_id")
    private List<CurriculoInformacaoAdicional> informacoesAdicionais;

    @OneToMany
    @JoinColumn(name = "experiencia_profissional_id")
    private List<CurriculoExperienciaProfissional> experienciasProfissionais;

    @OneToMany
    @JoinColumn(name = "formacao_academica_id")
    private List<CurriculoFormacaoAcademica> formacoesAcademicas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Curriculo> getCurriculos() {
        return curriculos;
    }

    public void setCurriculos(List<Curriculo> curriculos) {
        this.curriculos = curriculos;
    }

    public List<CurriculoLinkExterno> getLinksExternos() {
        return linksExternos;
    }

    public void setLinksExternos(List<CurriculoLinkExterno> linksExternos) {
        this.linksExternos = linksExternos;
    }

    public List<CurriculoInformacaoAdicional> getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setInformacoesAdicionais(List<CurriculoInformacaoAdicional> informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

    public List<CurriculoExperienciaProfissional> getExperienciasProfissionais() {
        return experienciasProfissionais;
    }

    public void setExperienciasProfissionais(List<CurriculoExperienciaProfissional> experienciasProfissionais) {
        this.experienciasProfissionais = experienciasProfissionais;
    }

    public List<CurriculoFormacaoAcademica> getFormacoesAcademicas() {
        return formacoesAcademicas;
    }

    public void setFormacoesAcademicas(List<CurriculoFormacaoAcademica> formacoesAcademicas) {
        this.formacoesAcademicas = formacoesAcademicas;
    }

}