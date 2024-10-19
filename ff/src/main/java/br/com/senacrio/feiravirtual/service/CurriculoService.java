package br.com.senacrio.feiravirtual.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import br.com.senacrio.feiravirtual.domain.Candidatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import br.com.senacrio.feiravirtual.domain.Curriculo;
import br.com.senacrio.feiravirtual.domain.CurriculoDadoPessoal;
import br.com.senacrio.feiravirtual.domain.Usuario;
import br.com.senacrio.feiravirtual.repository.CurriculoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CurriculoService {

	@Autowired
	CurriculoRepository curriculoRepo;

	@Autowired
	UsuarioServiceImpl usuarioService;

	public void cadastrar(Curriculo curriculo) {
		curriculoRepo.save(curriculo);
	}

	public List<Curriculo> buscarTudo() {
		return curriculoRepo.findByUsuario(buscaUsuarioAtual());
	}

	public Curriculo buscaPorID(Integer id) throws ObjectNotFoundException {
		Optional<Curriculo> curriculo = curriculoRepo.findById(id);
		return curriculo.orElseThrow(() -> new ObjectNotFoundException("Curriculo não encontrado. id:" + id));
	}

	public Curriculo alterar(Curriculo curriculoAlterado) throws ObjectNotFoundException {
		Curriculo curriculo = buscaPorID(curriculoAlterado.getId());
//
//		curriculo.setDadoPessoal(curriculoAlterado.getDadoPessoal());
//		curriculo.setExperienciasProfissionais(curriculoAlterado.getExperienciasProfissionais());
//		curriculo.setFormacoesAcademicas(curriculoAlterado.getFormacoesAcademicas());
//		curriculo.setInformacoesAdicionais(curriculoAlterado.getInformacoesAdicionais());
//		curriculo.setLinksExternos(curriculoAlterado.getLinksExternos());
//
		curriculo.setNome(curriculoAlterado.getNome());
		curriculo.setStatus(curriculoAlterado.getStatus());


		return salvar(curriculo);
	}

	public Curriculo salvar(Curriculo curriculo) {
		return curriculoRepo.save(montarCurriculo(curriculo));
	}

	public void excluir(Integer id) {
		Optional<Curriculo> curriculo = curriculoRepo.findById(id);
		curriculo.get().setStatus(-1);
	}

	private Curriculo montarCurriculo(Curriculo curriculo) {
//		curriculo.getExperienciasProfissionais().forEach(e -> e.setCurriculo(curriculo));
//		curriculo.getFormacoesAcademicas().forEach(e -> e.setCurriculo(curriculo));
//		curriculo.getInformacoesAdicionais().forEach(e -> e.setCurriculo(curriculo));
//		curriculo.getLinksExternos().forEach(e -> e.setCurriculo(curriculo));
//
		return curriculo;
	}

	public List<Map<String, BigInteger>> findDeficiente(String deficiente){
		List<Map<String, BigInteger>> map;

		// Listar tudo
		if (deficiente == null || deficiente.isEmpty()) {
			map = curriculoRepo.findAllDeficiente();
			return map;
		}

		map = curriculoRepo.findByDeficiente(deficiente);
		return map;
	}

	public List<Map<String, BigInteger>> findNivelInstrucao(String nivel) {

		// Listar tudo
		if (nivel == null || nivel.isEmpty()) {
			List<Map<String, BigInteger>> map = curriculoRepo.findAllNivelInstrucao();
			return map;
		}

		List<Map<String, BigInteger>> map = curriculoRepo.findByNivelInstrucao(nivel);
		return map;
	}

	private Usuario buscaUsuarioAtual() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Usuario user = usuarioService.findByCpf(name);
		return user;
	}

}