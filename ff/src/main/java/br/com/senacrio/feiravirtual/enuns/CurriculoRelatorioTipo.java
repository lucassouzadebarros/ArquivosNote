package br.com.senacrio.feiravirtual.enuns;

public enum CurriculoRelatorioTipo {

    RELATORIO_ESCOLARIDADE(0),
    RELATORIO_DEFICIENCIA(1),
    RELATORIO_IDADE(3),
    RELATORIO_REGIAO(4);

    private final int tipo;

    CurriculoRelatorioTipo (int tipoRelatorio) {
        tipo = tipoRelatorio;
    }

    public Integer getTipo() {
        return tipo;
    }

}