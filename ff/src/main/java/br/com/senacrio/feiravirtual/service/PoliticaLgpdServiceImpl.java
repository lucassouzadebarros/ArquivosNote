package br.com.senacrio.feiravirtual.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senacrio.feiravirtual.domain.PoliticaLgpd;
import br.com.senacrio.feiravirtual.repository.PoliticaLgpdRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PoliticaLgpdServiceImpl implements PoliticaLgpdService {

	@Autowired
	private PoliticaLgpdRepository repository;

	public PoliticaLgpd search(Integer id) throws ObjectNotFoundException {
		Optional<PoliticaLgpd> politicaLgpd = repository.findById(id);

		return politicaLgpd.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + PoliticaLgpd.class.getName()));
	}

	public List<PoliticaLgpd> searchAll() {
		return repository.findAll();
	}

	public PoliticaLgpd save(PoliticaLgpd politicaLgpd) {
		return repository.save(politicaLgpd);
	}

	public PoliticaLgpd edit(PoliticaLgpd politicaLgpd) throws ObjectNotFoundException {
		PoliticaLgpd politicaLgpdAntiga = search(politicaLgpd.getId());
		politicaLgpdAntiga.setDescricao(politicaLgpd.getDescricao());
		politicaLgpdAntiga.setVersao(politicaLgpd.getVersao());
		politicaLgpdAntiga.setStatus(politicaLgpd.getStatus());
		return save(politicaLgpdAntiga);
	}
}