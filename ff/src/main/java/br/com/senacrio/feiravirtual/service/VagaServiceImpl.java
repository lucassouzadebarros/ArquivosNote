package br.com.senacrio.feiravirtual.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senacrio.feiravirtual.domain.Empresa;
import br.com.senacrio.feiravirtual.domain.Vaga;
import br.com.senacrio.feiravirtual.repository.VagaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class VagaServiceImpl implements VagaService {

	@Autowired
	private VagaRepository repository;

	public Vaga search(Integer id) throws ObjectNotFoundException {
		Optional<Vaga> vaga = repository.findById(id);

		return vaga.orElseThrow(
				() -> new ObjectNotFoundException("não encontrado. id: " + id + ", Tipo!" + Vaga.class.getName()));
	}

	public Vaga searchByEmail(Integer id) throws ObjectNotFoundException {

		return null;
	}

	public List<Vaga> findAllByEmpresa(Empresa empresa) {
		return repository.findAllByEmpresa(empresa);
	}

	public List<Vaga> searchAll() {
		return repository.findAll();
	}

	public Vaga save(Vaga vaga) {
		return repository.save(vaga);
	}

	public Vaga edit(Vaga vaga) throws ObjectNotFoundException {
		Vaga vagaAntiga = search(vaga.getId());
		vagaAntiga.setSenac(vaga.getSenac());
		vagaAntiga.setCodigoSenac(vaga.getCodigoSenac());
		vagaAntiga.setUrlVaga(vaga.getUrlVaga());
		vagaAntiga.setCargo(vaga.getCargo());
		vagaAntiga.setDescricao(vaga.getDescricao());
		vagaAntiga.setQuantidade(vaga.getQuantidade());
		vagaAntiga.setRemuneracao(vaga.getRemuneracao());
		vagaAntiga.setRequisitos(vaga.getRequisitos());
		vagaAntiga.setAtividadesPrincipais(vaga.getAtividadesPrincipais());
		vagaAntiga.setBeneficios(vaga.getBeneficios());
		vagaAntiga.setObservacoes(vaga.getObservacoes());
		vagaAntiga.setDisponibilidadeInicio(vaga.getDisponibilidadeInicio());
		vagaAntiga.setDisponibilidadeFim(vaga.getDisponibilidadeFim());
		vagaAntiga.setStatus(vaga.getStatus());
		vagaAntiga.setAreaAtuacao(vaga.getAreaAtuacao());
		vagaAntiga.setBairro(vaga.getBairro());
		vagaAntiga.setCidade(vaga.getCidade());
		vagaAntiga.setEmpresa(vaga.getEmpresa());
		vagaAntiga.setEstado(vaga.getEstado());
		vagaAntiga.setSegmento(vaga.getSegmento());
		vagaAntiga.setVagaTipo(vaga.getVagaTipo());
		vagaAntiga.setCandidaturas(vaga.getCandidaturas());
		return save(vagaAntiga);
	}
}