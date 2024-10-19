package br.com.senacrio.feiravirtual.enuns;

public enum CurriculoStatus {

	HABILITADO(0), DESABILITADO(1);

	private final int valor;

	CurriculoStatus(int valorOpcao) {
		valor = valorOpcao;
	}

	public int getValor() {
		return valor;
	}

}