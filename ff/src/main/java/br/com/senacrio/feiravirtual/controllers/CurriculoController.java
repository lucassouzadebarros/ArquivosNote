package br.com.senacrio.feiravirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import br.com.senacrio.feiravirtual.domain.Curriculo;
import br.com.senacrio.feiravirtual.service.CurriculoDadoPessoalService;
import br.com.senacrio.feiravirtual.service.CurriculoService;
import br.com.senacrio.feiravirtual.service.DeficienciaService;
import br.com.senacrio.feiravirtual.service.ExperienciaProfissionalService;
import br.com.senacrio.feiravirtual.service.FormacaoAcademicaService;
import br.com.senacrio.feiravirtual.service.InformacaoAdicionalService;
import br.com.senacrio.feiravirtual.service.LinksExternosService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("curriculo")
public class CurriculoController {

	@Autowired
	CurriculoService curriculoService;

	@Autowired
	CurriculoDadoPessoalService dadoPessoalService;

	@Autowired
	DeficienciaService defService;

	@Autowired
	FormacaoAcademicaService faService;

	@Autowired
	ExperienciaProfissionalService epService;

	@Autowired
	InformacaoAdicionalService infoAdicioService;

	@Autowired
	LinksExternosService lksExternosService;

	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("curriculo/listarCurriculos");
		mv.addObject("curriculos", curriculoService.buscarTudo());
		return mv;
	}

	@GetMapping("/cadastrar")
	public ModelAndView curriculoUsuarioAutenticado(){
		ModelAndView mv = new ModelAndView("curriculo/usuarioAutenticado");
		mv.addObject("curriculo", new Curriculo());
		mv.addObject("dadoPessoal", dadoPessoalService.dadoPessoal());
		mv.addObject("curriculos", curriculoService.buscarTudo());
		mv.addObject("deficiencias", defService.buscaTudo());
		mv.addObject("formacoes", faService.findByUsuario());
		mv.addObject("experienciasProf", epService.findByUsuario());
		mv.addObject("informacoesAdicionais", infoAdicioService.findByUsuario());
		mv.addObject("linksExternos", lksExternosService.findByUsuario());

		return mv;
	}

//	@GetMapping("/cadastrar")
//	public ModelAndView cadastrar(){
//		ModelAndView mv = new ModelAndView("curriculo/cadastroCurriculo2");
//		mv.addObject("curriculo", new Curriculo());
//		mv.addObject("dadoPessoal", new CurriculoDadoPessoal());
//		return mv;
//	}

	@PostMapping("/salvar")
	public String salvar(Curriculo curriculo) {
		curriculoService.salvar(curriculo);
		return "redirect:/curriculo/cadastrar";
	}

	@PostMapping("/alterar")
	public String alterar(Curriculo curriculo) throws ObjectNotFoundException {
		curriculoService.alterar(curriculo);
		return "redirect:/curriculo/cadastrar";
	}

	@GetMapping("/exibir/{id}")
	public String exibir(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("curriculo/visualizacaoCurriculo");
		mv.addObject("curriculo", curriculoService.buscaPorID(id));
		return "redirect:/curriculo/cadastrar";
	}

	@SuppressWarnings("finally")
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Integer id) {
		try{
			curriculoService.excluir(id);
		}finally {
			return "redirect:/curriculo/cadastrar";
		}
	}

}