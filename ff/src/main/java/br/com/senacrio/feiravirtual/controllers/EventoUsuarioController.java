package br.com.senacrio.feiravirtual.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senacrio.feiravirtual.domain.EventoUsuario;
import br.com.senacrio.feiravirtual.service.EventoService;
import br.com.senacrio.feiravirtual.service.EventoUsuarioService;
import br.com.senacrio.feiravirtual.service.UsuarioService;

@Controller
@RequestMapping("/eventoUsuario")
public class EventoUsuarioController {

    Logger logger = LoggerFactory.getLogger(EventoUsuarioController.class);

    @Autowired
    private EventoService eventoService;

    @Autowired
    private EventoUsuarioService eventoUsuarioService;

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/cadastrar")
    public ModelAndView create() {
        logger.info("Request received on [GET][/eventoUsuario/cadastrar]");

        ModelAndView mv = new ModelAndView("/eventoUsuario/cadastrar");
        mv.addObject("eventoUsuarioDomain", new EventoUsuario());
        mv.addObject("usuarioDomainList", usuarioService.searchAll());
        mv.addObject("eventoDomainList", eventoService.findAll());

        logger.info("Returning view to the client");
        return mv;
    }

    @PostMapping("/salvar")
    public String save(EventoUsuario eventoUsuarioDomain) {
        logger.info("Request received on [GET][/eventoUsuario/salvar]");

        eventoUsuarioService.salvar(eventoUsuarioDomain);

        logger.info("Returning view to the client");
        return "redirect:/evento/relatorios";
    }



}