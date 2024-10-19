package br.com.senacrio.feiravirtual.controllers;

import br.com.senacrio.feiravirtual.domain.AcessoUsuario;
import br.com.senacrio.feiravirtual.domain.Stand;
import br.com.senacrio.feiravirtual.service.AcessoUsuarioService;
import br.com.senacrio.feiravirtual.service.StandService;
import br.com.senacrio.feiravirtual.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/acessoUsuario")
public class AcessoUsuarioController {

    private final AcessoUsuarioService acessoUsuarioService;
    private final UsuarioService usuarioService;
    private final StandService standService;

    public AcessoUsuarioController(AcessoUsuarioService acessoUsuarioService,
                                   UsuarioService usuarioService,
                                   StandService standService) {
        this.acessoUsuarioService = acessoUsuarioService;
        this.usuarioService = usuarioService;
        this.standService = standService;
    }

    @GetMapping("/standsVisitadosPorUsuario")
    public ModelAndView listarTodosAcessosUsuarios() {
        ModelAndView mv = new ModelAndView("stand-usuario/listarStandsVisitadosPorUsuario");
        mv.addObject("usuarios", usuarioService.searchAll());
        mv.addObject("acessoUsuario", new AcessoUsuario());
        mv.addObject("acessos", acessoUsuarioService.buscarTodosAcessosUsuario());
        return mv;
    }

    @GetMapping("/usuariosPorDiaNoStand")
    public ModelAndView listarQuantidadeDeUsuariosPorDia() {
        ModelAndView mv = new ModelAndView("stand-usuario/listarUsuariosPorDiaNoStand");
        mv.addObject("stands", standService.buscarTodosStands());
        mv.addObject("acessoUsuario", new AcessoUsuario());
        mv.addObject("relatorios", acessoUsuarioService.quantosUsuariosPorDia());
        return mv;
    }

    @PostMapping("/usuariosPorDiaNoStand/filtroStand")
    public ModelAndView listarQuantidadeDeUsuariosPorDiaNoStand(AcessoUsuario acessoUsuario) {
        ModelAndView mv = new ModelAndView("stand-usuario/listarUsuariosPorDiaNoStand");
        mv.addObject("stands", standService.buscarTodosStands());
        mv.addObject("acessoUsuario", acessoUsuario);
        mv.addObject("relatorios", acessoUsuarioService.quantosUsuariosPorDiaNoStand(acessoUsuario.getStand()));
        return mv;
    }

    @PostMapping("/standsVisitadosPorUsuario/filtroUsuario")
    public ModelAndView listarTodosAcessosPorUsuario(AcessoUsuario acessoUsuario) {
        ModelAndView mv = new ModelAndView("stand-usuario/listarStandsVisitadosPorUsuario");
        mv.addObject("usuarios", usuarioService.searchAll());
        mv.addObject("acessoUsuario", acessoUsuario);
        mv.addObject("acessos", acessoUsuarioService.buscarAcessosUsuarioPorUsuario(acessoUsuario.getUsuario()));
        return mv;
    }

}