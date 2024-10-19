package br.com.senacrio.feiravirtual.service;

import java.util.List;

import br.com.senacrio.feiravirtual.domain.Empresa;
import br.com.senacrio.feiravirtual.domain.Vaga;
import javassist.tools.rmi.ObjectNotFoundException;

public interface VagaService {

	Vaga search(Integer id) throws ObjectNotFoundException;

	Vaga searchByEmail(Integer id) throws ObjectNotFoundException;

	List<Vaga> findAllByEmpresa(Empresa empresa);

	List<Vaga> searchAll();

	Vaga save(Vaga vaga);

	Vaga edit(Vaga vaga) throws ObjectNotFoundException;
}