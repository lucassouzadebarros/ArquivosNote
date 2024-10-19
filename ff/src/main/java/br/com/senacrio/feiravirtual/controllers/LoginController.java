package br.com.senacrio.feiravirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senacrio.feiravirtual.service.UsuarioServiceImpl;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("/paginaLogin");
        return mv;
    }

    @GetMapping("/inicio")
    public ModelAndView inicio() {
        ModelAndView mv = new ModelAndView("/dashboard/dashboardadmin");
        //mv.addObject("usuarioLogado", usuarioServiceImpl.usuarioLogado());
        return mv;
    }

   /* @GetMapping("/aside")
    public ModelAndView aside() {
        ModelAndView mv = new ModelAndView("fragments/aside");
        mv.addObject("usuarioLogado", usuarioServiceImpl.usuarioLogado());
        return mv;
    }*/
}