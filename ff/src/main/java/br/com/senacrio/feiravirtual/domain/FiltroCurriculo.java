package br.com.senacrio.feiravirtual.domain;

import java.util.List;

public class FiltroCurriculo {

    private Integer tipoGrafico;
    private String dataInicio;
    private String dataFim;
    private List<String> escolaridade;
    private List<String> tipoDeficiencia;
    private List<String> areaAtuacao;
    private List<String> faixaEtaria;
    private List<String> bairro;

    public Integer getTipoGrafico() {
        return tipoGrafico;
    }
    public void setTipoGrafico(Integer tipoGrafico) {
        this.tipoGrafico = tipoGrafico;
    }
    public String getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }
    public String getDataFim() {
        return dataFim;
    }
    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
    public List<String> getEscolaridade() {
        return escolaridade;
    }
    public void setEscolaridade(List<String> escolaridade) {
        this.escolaridade = escolaridade;
    }
    public List<String> getTipoDeficiencia() {
        return tipoDeficiencia;
    }
    public void setTipoDeficiencia(List<String> tipoDeficiencia) {
        this.tipoDeficiencia = tipoDeficiencia;
    }
    public List<String> getAreaAtuacao() {
        return areaAtuacao;
    }
    public void setAreaAtuacao(List<String> areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }
    public List<String> getFaixaEtaria() {
        return faixaEtaria;
    }
    public void setFaixaEtaria(List<String> faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }
    public List<String> getBairro() {
        return bairro;
    }
    public void setBairro(List<String> bairro) {
        this.bairro = bairro;
    }

}