package br.com.senacrio.feiravirtual.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senacrio.feiravirtual.domain.EtapaProcesso;
import br.com.senacrio.feiravirtual.repository.EtapaProcessoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class EtapaProcessoServiceImpl implements EtapaProcessoService {

	@Autowired
	private EtapaProcessoRepository repository;

	public EtapaProcesso search(Integer id) throws ObjectNotFoundException {
		Optional<EtapaProcesso> etapaProcesso = repository.findById(id);

		return etapaProcesso.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + EtapaProcesso.class.getName()));
	}

	public List<EtapaProcesso> searchAll() {
		return repository.findAll();
	}

	public EtapaProcesso save(EtapaProcesso etapaProcesso) {
		return repository.save(etapaProcesso);
	}

	public EtapaProcesso edit(EtapaProcesso etapaProcesso) throws ObjectNotFoundException {
		EtapaProcesso etapaProcessoAntiga = search(etapaProcesso.getEtapaProcessoId());
		etapaProcessoAntiga.setEtapaProcessoDescricao(etapaProcesso.getEtapaProcessoDescricao());
		etapaProcessoAntiga.setEtapaProcessoStatus(etapaProcesso.getEtapaProcessoStatus());
		return save(etapaProcessoAntiga);
	}
}