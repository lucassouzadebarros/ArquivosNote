package br.com.senacrio.feiravirtual.enuns;

public enum FormacaoAcademicaStatus {

	TRABALHO_ATUAL(0),
	ULTIMO_TRABALHO(1);

	private final int valor;

	FormacaoAcademicaStatus(int valorOpcao){
		valor = valorOpcao;
	}

	public int getValor(){
		return valor;
	}

}