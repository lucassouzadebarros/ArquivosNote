package br.com.senacrio.feiravirtual.service;

import java.util.List;

import br.com.senacrio.feiravirtual.domain.PoliticaLgpd;
import javassist.tools.rmi.ObjectNotFoundException;

public interface PoliticaLgpdService {

	PoliticaLgpd search(Integer id) throws ObjectNotFoundException;

	List<PoliticaLgpd> searchAll();

	PoliticaLgpd save(PoliticaLgpd politicaLgpd);

	PoliticaLgpd edit(PoliticaLgpd politicaLgpd) throws ObjectNotFoundException;
}