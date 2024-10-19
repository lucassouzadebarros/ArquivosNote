package br.com.senacrio.feiravirtual.service;

import br.com.senacrio.feiravirtual.domain.Responsavel;
import br.com.senacrio.feiravirtual.domain.Usuario;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.senacrio.feiravirtual.domain.Empresa;
import br.com.senacrio.feiravirtual.repository.EmpresaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

	@Autowired
	EmpresaRepository empresaRepository;
	@Autowired
	private ResponsavelService responsavelServiceImpl;

	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;

	public Empresa search(Integer id) throws ObjectNotFoundException {
		Optional<Empresa> empresa = empresaRepository.findById(id);

		return empresa.orElseThrow(() -> new ObjectNotFoundException(
				" Não encontrado. ID solicitado: " + id + ", Tipo: " + Empresa.class.getName()));
	}

	public Empresa findIdByCnpj(String cnpj) throws ObjectNotFoundException {
		Empresa empresa = empresaRepository.findByEmpresaCnpj(cnpj);
		return empresa;
	}

	public Empresa searchEmpresaById() throws ObjectNotFoundException {

		Responsavel responsavel;

		String cpf = SecurityContextHolder.getContext().getAuthentication().getName();

		Usuario usuario = usuarioServiceImpl.findByCpf(cpf);

		responsavel  = responsavelServiceImpl.buscaPorID(usuario.getId());

		Empresa empresa = this.findIdByCnpj(responsavel.getEmpresa().getEmpresaCnpj());

		return empresa;
	}

	public List<Empresa> findAllByEmpresa() {

		return empresaRepository.findAll();
	}

	public List<Empresa> searchAll() {

		return empresaRepository.findAll();
	}

	public Iterable<Empresa> buscarTodasEmpresas() {
		Iterable<Empresa> empresa = empresaRepository.findAll();
		return empresa;
	}

	public Empresa save(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	public List<Empresa> saveAll(List<Empresa> empresas) {
		return empresaRepository.saveAll(empresas);
	}

	public Empresa edit(Empresa em) throws ObjectNotFoundException {
		Empresa empresa = search(em.getEmpresaId());
		empresa.setEmpresaNome(em.getEmpresaNome());
		empresa.setEmpresaCnpj(em.getEmpresaCnpj());
		empresa.setEmpresaDescricao(em.getEmpresaDescricao());
		empresa.setEmpresaStatus(em.getEmpresaStatus());
		return save(empresa);
	}

	public void apagarEmpresa(Integer id) throws ObjectNotFoundException {
		//empresaRepository.deleteById(id);
		Empresa empresa = search(id);
		empresa.setEmpresaStatus(-1);
		save(empresa);
	}

}
