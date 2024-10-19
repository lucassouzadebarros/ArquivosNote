package br.com.senacrio.feiravirtual.controllers;


import br.com.senacrio.feiravirtual.domain.Stand;
import br.com.senacrio.feiravirtual.service.EmpresaService;
import br.com.senacrio.feiravirtual.service.StandService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/stand")
public class StandController {

	private final EmpresaService empresaService;
	private final StandService standService;

	public StandController(EmpresaService empresaService,
						   StandService standService) {
		this.empresaService = empresaService;
		this.standService = standService;
	}

	@GetMapping("/listar")
	public ModelAndView listarTodosStands() {
		ModelAndView mv = new ModelAndView("stand/listar");
		mv.addObject("stands", standService.buscarTodosStands());
		return mv;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrarStand() {
		ModelAndView mv = new ModelAndView("stand/cadastrar");
		mv.addObject("empresas", empresaService.buscarTodasEmpresas());
		mv.addObject("stand", new Stand());
		return mv;
	}

	@PostMapping("/salvar")
	public ModelAndView salvarStand(Stand stand) {
		standService.salvar(stand);
		return listarTodosStands();
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") int id) {
		try {
			standService.excluir(id);
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/stand/listar");
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterarStand(@PathVariable("id") Integer idStand) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("stand/editar");
		mv.addObject("empresas", empresaService.buscarTodasEmpresas());
		mv.addObject("stand", standService.buscaPorID(idStand));
		return mv;
	}

	@PostMapping("/alterar")
	public ModelAndView alterar(Stand standAlterado) throws ObjectNotFoundException{
		standService.salvarAlteracao(standAlterado);
		return new ModelAndView("redirect:/stand/listar");
	}

}
