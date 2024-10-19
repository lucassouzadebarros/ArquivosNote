package br.com.senacrio.feiravirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senacrio.feiravirtual.domain.EtapaProcesso;
import br.com.senacrio.feiravirtual.service.EtapaProcessoServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("etapaProcesso")
public class EtapaProcessoController {

	@Autowired
	private EtapaProcessoServiceImpl etapaProcessoServiceImpl;

	@GetMapping("/etapaProcessos")
	public ModelAndView listaEtapaProcesso() {
		ModelAndView mv = new ModelAndView("etapaProcesso/tabelaEtapaProcesso");
		mv.addObject("etapaProcessos", etapaProcessoServiceImpl.searchAll());
		return mv;
	}

	@GetMapping("/cadastraEtapaProcesso")
	public ModelAndView formCadastraEtapaProcesso() {
		ModelAndView mv = new ModelAndView("etapaProcesso/formEtapaProcesso");
		mv.addObject("etapaProcesso", new EtapaProcesso());
		return mv;
	}

	@GetMapping("/alteraEtapaProcesso/{id}")
	public ModelAndView alteraEtapaProcesso(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("etapaProcesso/alteraEtapaProcesso");
		mv.addObject("etapaProcesso", etapaProcessoServiceImpl.search(id));
		return mv;
	}

	@PostMapping("/alteraSalvaEtapaProcesso")
	public ModelAndView alteraSalvaEtapaProcesso(EtapaProcesso etapaProcesso) throws ObjectNotFoundException {
		etapaProcessoServiceImpl.edit(etapaProcesso);
		return listaEtapaProcesso();
	}

	@PostMapping("/salvaEtapaProcesso")
	public ModelAndView salvaEtapaProcesso(EtapaProcesso etapaProcesso) {
		etapaProcessoServiceImpl.save(etapaProcesso);
		return listaEtapaProcesso();
	}
}