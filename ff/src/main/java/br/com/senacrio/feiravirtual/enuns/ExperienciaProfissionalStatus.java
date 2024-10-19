package br.com.senacrio.feiravirtual.enuns;

public enum ExperienciaProfissionalStatus {

    FORMADO(0),
    EM_FORMACAO(1);

    private final int valor;

    ExperienciaProfissionalStatus(int valorOpcao){
        valor = valorOpcao;
    }

    public int getValor(){
        return valor;
    }

}