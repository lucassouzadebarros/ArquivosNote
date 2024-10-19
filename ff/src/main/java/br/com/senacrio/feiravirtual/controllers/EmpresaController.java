package br.com.senacrio.feiravirtual.controllers;

import br.com.senacrio.feiravirtual.domain.Responsavel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.senacrio.feiravirtual.domain.Empresa;
import br.com.senacrio.feiravirtual.service.EmpresaService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	EmpresaService empresaService;

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("/empresa/cadastrar");
		mv.addObject("empresa", new Empresa());
		return mv;
	}

	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("empresa/listar");
		mv.addObject("empresa", empresaService.searchAll());
		return mv;
	}

	@PostMapping("/salvar")
	public String salvar(Empresa empresa, RedirectAttributes attr) {
		empresaService.save(empresa);
		attr.addFlashAttribute("sucess", "Empresa cadastrada com sucesso!");
		return "redirect:/empresa/listar";
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("empresa/editar");
		mv.addObject("empresa", empresaService.search(id));
		return mv;
	}

    @PostMapping("/alterar")
    public ModelAndView alterar(Empresa alterado) throws ObjectNotFoundException{
        empresaService.save(alterado);
        return listar();
    }

	@PostMapping ("/editar")
	public ModelAndView editar(Empresa empresa) throws ObjectNotFoundException{
		empresaService.edit(empresa);
		return listar();
	}


	@GetMapping("/deletar/{id}")
	public String deletar(@PathVariable("id") Integer Id, RedirectAttributes attr) {
		//empresaService.delete(Id);
		try {
			empresaService.apagarEmpresa(Id);
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
		attr.addFlashAttribute("Sucess", "Empresa excluida do sistema!");
		return "redirect:/empresa/listar";
	}

}
