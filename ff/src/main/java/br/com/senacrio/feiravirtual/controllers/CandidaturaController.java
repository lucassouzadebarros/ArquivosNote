package br.com.senacrio.feiravirtual.controllers;

import br.com.senacrio.feiravirtual.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.senacrio.feiravirtual.domain.Candidatura;
import br.com.senacrio.feiravirtual.service.CandidaturaService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/candidatura")
public class CandidaturaController {

	@Autowired
	CandidaturaService candidaturaService;

	@Autowired
	VagaService vagaService;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	EtapaProcessoService etapaProcessoService;

	@Autowired
	CurriculoService curriculoService;

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("/candidatura/cadastrar");
		mv.addObject("vagas", vagaService.searchAll());
		mv.addObject("usuarios", usuarioService.searchAll());
		mv.addObject("etapasprocessos", etapaProcessoService.searchAll());
		mv.addObject("curriculos", curriculoService.buscarTudo());
		mv.addObject("candidatura", new Candidatura());
		return mv;
	}

	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("candidatura/listar");
		mv.addObject("candidatura", candidaturaService.searchAll());
		return mv;
	}

	@PostMapping("/salvar")
	public String salvar(Candidatura candidatura, RedirectAttributes attr) {
		candidaturaService.save(candidatura);
		attr.addFlashAttribute("Sucesso", "Candidato Inserido com sucesso.");
		return "redirect:/candidatura/listar";
	}

	@GetMapping("/editar/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("candidatura/editar");
		mv.addObject("usuarios", usuarioService.searchAll());
		mv.addObject("vagas", vagaService.searchAll());
		mv.addObject("curriculos", curriculoService.buscarTudo());
		mv.addObject("etapasprocessos", etapaProcessoService.searchAll());
		mv.addObject("candidatura", candidaturaService.search(id));
		return mv;
	}

	@PostMapping ("/editar")
	public ModelAndView editar(Candidatura candidatura) throws ObjectNotFoundException{
		candidaturaService.edit(candidatura);
		return listar();
	}

	@GetMapping("/deletar/{candidatura_id}")
	public String deletar(@PathVariable("candidatura_id") Integer candidatura_id, RedirectAttributes attr) {
		candidaturaService.delete(candidatura_id);
		attr.addFlashAttribute("Sucesso", "Candidatura Excluida.");
		return "redirect:/candidatura/listar";
	}
}
