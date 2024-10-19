package br.com.senacrio.feiravirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import br.com.senacrio.feiravirtual.domain.Curriculo;
import br.com.senacrio.feiravirtual.domain.CurriculoDadoPessoal;
import br.com.senacrio.feiravirtual.service.CurriculoDadoPessoalService;
import br.com.senacrio.feiravirtual.service.CurriculoService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("dadoPessoal")
public class DadoPessoalController {

    @Autowired
    CurriculoService curriculoService;

    @Autowired
    CurriculoDadoPessoalService dadoPessoalService;


//	@GetMapping("")
//	public ModelAndView listar() {
//		ModelAndView mv = new ModelAndView("curriculo/listarCurriculos");
//		mv.addObject("curriculos", curriculoService.buscarTudo());
//		return mv;
//	}

//	@GetMapping("/cadastrar")
//	public ModelAndView cadastrar(){
//		ModelAndView mv = new ModelAndView("curriculo/cadastroCurriculo2");
//		mv.addObject("curriculo", new Curriculo());
//		mv.addObject("dadoPessoal", new CurriculoDadoPessoal());
//		return mv;
//	}

    @PostMapping("/salvar")
    @ResponseBody
    public ModelAndView salvar(CurriculoDadoPessoal dadoPessoal) throws ObjectNotFoundException {
        dadoPessoalService.salvar(dadoPessoal);
        return new ModelAndView("redirect:/curriculo/cadastrar");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView editar(@PathVariable("id") Integer id) throws ObjectNotFoundException {
        ModelAndView mv = new ModelAndView("curriculo/alterarCurriculo");
        mv.addObject("curriculo", curriculoService.buscaPorID(id));
        return new ModelAndView("redirect:/curriculo/cadastrar");
    }

    @PostMapping("/alterar")
    public ModelAndView alterar(Curriculo curriculo) throws ObjectNotFoundException {
        curriculoService.alterar(curriculo);
        return new ModelAndView("redirect:/curriculo/cadastrar");
    }

//	@GetMapping("/exibir/{id}")
//	public ModelAndView exibir(@PathVariable("id") Integer id) throws ObjectNotFoundException {
//		ModelAndView mv = new ModelAndView("curriculo/visualizacaoCurriculo");
//		mv.addObject("curriculo", curriculoService.buscaPorID(id));
//		return mv;
//	}

    @SuppressWarnings("finally")
    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") Integer id) {
        try{
            curriculoService.excluir(id);
        }finally {
            return new ModelAndView("redirect:/curriculo/cadastrar");
        }
    }
}