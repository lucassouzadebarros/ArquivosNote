package br.com.senacrio.feiravirtual.service;

import java.util.List;

import br.com.senacrio.feiravirtual.domain.EtapaProcesso;
import javassist.tools.rmi.ObjectNotFoundException;

public interface EtapaProcessoService {

	EtapaProcesso search(Integer id) throws ObjectNotFoundException;

	List<EtapaProcesso> searchAll();

	EtapaProcesso save(EtapaProcesso etapaProcesso);

	EtapaProcesso edit(EtapaProcesso etapaProcesso) throws ObjectNotFoundException;
}