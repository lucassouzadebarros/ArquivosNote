package br.com.senacrio.feiravirtual.service;

import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senacrio.feiravirtual.domain.Candidatura;
import br.com.senacrio.feiravirtual.repository.CandidaturaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CandidaturaService {

	@Autowired
	CandidaturaRepository candidaturaRepository;

	public Candidatura search(Integer id) throws ObjectNotFoundException {
		Optional<Candidatura> candidatura = candidaturaRepository.findById(id);

		return candidatura.orElseThrow(() -> new ObjectNotFoundException(
				" Não encontrado. ID solicitado: " + id + ", Tipo: " + Candidatura.class.getName()));
	}

	public List<Candidatura> searchAll() {
		return candidaturaRepository.findAll();
	}

	public Candidatura save(Candidatura candidatura) {
		candidatura.setData(LocalDateTime.now());
		return candidaturaRepository.save(candidatura);
	}

	public List<Candidatura> saveAll(List<Candidatura> candidaturas) {
		return candidaturaRepository.saveAll(candidaturas);
	}

	public Candidatura edit(Candidatura ct) throws ObjectNotFoundException {
		Candidatura candidatura = search(ct.getId());
		candidatura.setUsuario(ct.getUsuario());
		candidatura.setVaga(ct.getVaga());
		candidatura.setCurriculo(ct.getCurriculo());
		candidatura.setEtapaProcesso(ct.getEtapaProcesso());
		candidatura.setCurriculo(ct.getCurriculo());
		return save(candidatura);
	}

	public void delete(Integer id) {
		candidaturaRepository.deleteById(id);
	}
}