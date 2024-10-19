package br.com.senacrio.feiravirtual.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senacrio.feiravirtual.service.AreaAtuacaoService;
import br.com.senacrio.feiravirtual.service.BairroService;
import br.com.senacrio.feiravirtual.service.CandidaturaService;
import br.com.senacrio.feiravirtual.service.CidadeService;
import br.com.senacrio.feiravirtual.service.EmpresaService;
import br.com.senacrio.feiravirtual.service.EstadoService;
import br.com.senacrio.feiravirtual.service.SegmentoService;
import br.com.senacrio.feiravirtual.service.VagaTipoService;
import br.com.senacrio.feiravirtual.domain.Vaga;
import br.com.senacrio.feiravirtual.service.UsuarioServiceImpl;
import br.com.senacrio.feiravirtual.service.VagaServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/vaga")
public class VagaController {

	@Autowired
	private VagaServiceImpl vagaServiceImpl;

	@Autowired
	private CandidaturaService candidaturaServiceImpl;

	@Autowired
	private AreaAtuacaoService areaAtuacaoServiceImpl;

	@Autowired
	private EstadoService estadoServiceImpl;

	@Autowired
	private CidadeService cidadeServiceImpl;

	@Autowired
	private BairroService bairroServiceImpl;

	@Autowired
	private VagaTipoService vagaTipoServiceImpl;

	@Autowired
	private EmpresaService empresaServiceImpl;

	@Autowired
	private SegmentoService segmentoServiceImpl;

	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;

	@RequestMapping("/index")
	public String showHome() {
		return "vaga/index";
	}

	@GetMapping("/vagas")
	public ModelAndView listaVaga() throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("vaga/tabelaVaga");
		mv.addObject("usuarioLogado", usuarioServiceImpl.usuarioLogado());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMINEMP"))
				|| auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_EMP"))) {

			mv.addObject("vagas", vagaServiceImpl.findAllByEmpresa(empresaServiceImpl.searchEmpresaById()));
		} else {
			mv.addObject("vagas", vagaServiceImpl.searchAll());
		}
		return mv;
	}

	@GetMapping("/relatorio")
	public ResponseEntity<?> getDataForPiechart() throws ObjectNotFoundException {
		List<Vaga> vagas;

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMINEMP"))
				|| auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_EMP"))) {
			vagas = vagaServiceImpl.findAllByEmpresa(empresaServiceImpl.searchEmpresaById());
		} else {
			vagas = vagaServiceImpl.searchAll();
		}
		return new ResponseEntity<>(vagas, HttpStatus.OK);
	}

	@GetMapping("/cadastraVaga")
	public ModelAndView formCadastraVaga() throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("vaga/cadastraVaga");
		mv.addObject("usuarioLogado", usuarioServiceImpl.usuarioLogado());
		mv.addObject("candidaturas", candidaturaServiceImpl.searchAll());
		mv.addObject("areaAtuacoes", areaAtuacaoServiceImpl.searchAll());
		mv.addObject("estados", estadoServiceImpl.searchAll());
		mv.addObject("cidades", cidadeServiceImpl.buscarTodasCidades());
		mv.addObject("bairros", bairroServiceImpl.buscarTodosBairros());
		mv.addObject("vagaTipos", vagaTipoServiceImpl.searchAll());

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMINEMP"))
				|| auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_EMP"))) {
			mv.addObject("empresaEmp", empresaServiceImpl.search(empresaServiceImpl.searchEmpresaById().getEmpresaId()));
		} else {
			mv.addObject("empresas", empresaServiceImpl.searchAll());
		}
		mv.addObject("segmentos", segmentoServiceImpl.searchAll());
		mv.addObject("vaga", new Vaga());

		return mv;
	}

	@GetMapping("/alteraVaga/{id}")
	public ModelAndView alteraVaga(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("vaga/alteraVaga");
		mv.addObject("usuarioLogado", usuarioServiceImpl.usuarioLogado());
		mv.addObject("candidaturas", candidaturaServiceImpl.searchAll());
		mv.addObject("areaAtuacoes", areaAtuacaoServiceImpl.searchAll());
		mv.addObject("estados", estadoServiceImpl.searchAll());
		mv.addObject("cidades", cidadeServiceImpl.buscarTodasCidades());
		mv.addObject("bairros", bairroServiceImpl.buscarTodosBairros());
		mv.addObject("vagaTipos", vagaTipoServiceImpl.searchAll());
		mv.addObject("empresas", empresaServiceImpl.searchAll());
		mv.addObject("empresaEmp", empresaServiceImpl.search(empresaServiceImpl.searchEmpresaById().getEmpresaId()));
		mv.addObject("segmentos", segmentoServiceImpl.searchAll());
		mv.addObject("vaga", vagaServiceImpl.search(id));
		return mv;
	}

	@PostMapping("/salvaAlteraVaga")
	public ModelAndView alteraSalvaVaga(Vaga vaga) throws ObjectNotFoundException {
		vagaServiceImpl.edit(vaga);
		return listaVaga();
	}

	@PostMapping("/salvaVaga")
	public ModelAndView salvaVaga(Vaga vaga) throws ObjectNotFoundException {
		vagaServiceImpl.save(vaga);
		return listaVaga();
	}
}