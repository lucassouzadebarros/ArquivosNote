package br.com.senacrio.feiravirtual.service;

import br.com.senacrio.feiravirtual.domain.Empresa;
import br.com.senacrio.feiravirtual.domain.Responsavel;
import br.com.senacrio.feiravirtual.domain.Usuario;
import br.com.senacrio.feiravirtual.repository.ResponsavelRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsavelService {

	private final ResponsavelRepository responsavelRepository;

	@Autowired
	private EmpresaService empresaServiceImpl;

	public ResponsavelService(ResponsavelRepository responsavelRepository) {
		this.responsavelRepository = responsavelRepository;
	}

	public Iterable<Responsavel> searchForResponsible() {
		Iterable<Responsavel> resp = responsavelRepository.findAll();
		return resp;
	}

	public Responsavel findAllByEmpresa(Empresa empresa) throws ObjectNotFoundException{

		Responsavel responsaveis = responsavelRepository.findByEmpresa(empresa);
		return responsaveis;
	}
	

	public List<Responsavel> findAllByEmpresaUsu(Usuario id) throws ObjectNotFoundException{

		List<Responsavel> responsaveis =  responsavelRepository.findByusuario(id);
		return responsaveis;
	}

	public Responsavel buscaPorID(Integer id) throws ObjectNotFoundException{
		Optional<Responsavel> responsavel = responsavelRepository.findById(id);
		return responsavel.orElseThrow(() -> new ObjectNotFoundException("Responsavel não encontrado. id: " +id));
	}

	public List<Responsavel> searchAll() {
		return responsavelRepository.findAll();
	}

	public Responsavel save(Responsavel responsavel) {
		return responsavelRepository.save(responsavel);
	}

	public List<Responsavel> saveAll(List<Responsavel> responsaveis) {
		return responsavelRepository.saveAll(responsaveis);
	}

	public void excluir(int id) throws ObjectNotFoundException {
		Responsavel responsavel = buscaPorID(id);
		responsavel.setResponsavelStatus(0);
		save(responsavel);
	}

	public Responsavel salvarAlteracao(Responsavel alterado) throws ObjectNotFoundException {
		Responsavel responsavel = buscaPorID(alterado.getResponsavelId());
		responsavel.setResponsavelEmail(alterado.getResponsavelEmail());
		responsavel.setEmpresa(alterado.getEmpresa());
		responsavel.setResponsavelNomeCompleto(alterado.getResponsavelNomeCompleto());
		responsavel.setResponsavelUsuario(alterado.getResponsavelUsuario());
		responsavel.setResponsavelSenha(alterado.getResponsavelSenha());
		responsavel.setResponsavelStatus(alterado.getResponsavelStatus());
		responsavel.setResponsavelTelefone(alterado.getResponsavelTelefone());
		return save(responsavel);
	}

}
