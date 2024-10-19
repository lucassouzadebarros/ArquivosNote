package br.com.senacrio.feiravirtual.controllers;

import br.com.senacrio.feiravirtual.domain.Responsavel;
import br.com.senacrio.feiravirtual.service.EmpresaService;
import br.com.senacrio.feiravirtual.service.ResponsavelService;
import br.com.senacrio.feiravirtual.service.UsuarioService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/responsavel")
public class ResponsavelController {

	private final ResponsavelService responsavelService;
	private final EmpresaService empresaService;
	private final UsuarioService usuarioService;

	public ResponsavelController(EmpresaService empresaService,
								 ResponsavelService responsavelService,
								 UsuarioService usuarioService) {
		this.empresaService = empresaService;
		this.responsavelService = responsavelService;
		this.usuarioService = usuarioService;
	}

	@GetMapping("/listar")
	public ModelAndView listarResponsavel() {
		ModelAndView mv = new ModelAndView("responsavel/listar");
		mv.addObject("responsavelList", responsavelService.searchForResponsible());
		return mv;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrarResponavel() {
		ModelAndView mv = new ModelAndView("responsavel/cadastrar");
		mv.addObject("empresas", empresaService.buscarTodasEmpresas());
		mv.addObject("usuarios", usuarioService.searchAll());
		mv.addObject("responsavel", new Responsavel());
		return mv;

	}

	@PostMapping("/salvar")
	public ModelAndView salvarResponsavel(Responsavel responsavel) {
		responsavelService.save(responsavel);
		return listarResponsavel();
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterarResponsavel(@PathVariable("id") Integer idResp) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("responsavel/editar");
		mv.addObject("empresas", empresaService.buscarTodasEmpresas());
		mv.addObject("usuarios", usuarioService.searchAll());
		mv.addObject("responsavel", responsavelService.buscaPorID(idResp));
		return mv;
	}

	@PostMapping("/alterar")
	public ModelAndView alterar(Responsavel alterado) throws ObjectNotFoundException{
		responsavelService.salvarAlteracao(alterado);
		return new ModelAndView("redirect:/responsavel/listar");
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") int id) {
		try {
			responsavelService.excluir(id);
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/responsavel/listar");
	}


}
