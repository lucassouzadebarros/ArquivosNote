package br.com.senacrio.feiravirtual.controllers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;

import br.com.senacrio.feiravirtual.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.senacrio.feiravirtual.domain.Usuario;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;

	@Autowired
	private CandidaturaService candidaturaServiceImpl;

	@Autowired
	private CurriculoService curriculoServiceImpl;

	@Autowired
	private EventoUsuarioService eventoUsuarioServiceImpl;

	@Autowired
	private SegmentoUsuarioService segmentoUsuarioServiceImpl;

	@Autowired
	private EmailServiceImpl emailServiceImpl;

	@Autowired
	private EmpresaService empresaServiceImpl;

	@Autowired
	private ResponsavelService responsavelServiceImpl;

	@Autowired
	private PoliticaLgpdServiceImpl politicaLgpdServiceImpl;

	@Autowired
	private RoleServiceImpl roleServiceImpl;

	@GetMapping("/email")
	public ModelAndView email(Usuario usuario) {
		ModelAndView mv = new ModelAndView("usuario/validaEmailUsuario");
		return mv;
	}

	@GetMapping("/registro")
	public ModelAndView registro() {
		ModelAndView mv = new ModelAndView("usuario/paginaRegistro");
		mv.addObject("politicas", politicaLgpdServiceImpl.searchAll());
		mv.addObject("roles", roleServiceImpl.searchAll());
		mv.addObject("usuario", new Usuario());
		return mv;
	}

	@GetMapping("/politicaLgpd")
	public ModelAndView politicaLgpdVersao() {
		ModelAndView mv = new ModelAndView("usuario/politicaModal");
		mv.addObject("politicas", politicaLgpdServiceImpl.searchAll());
		return mv;
	}

	@GetMapping("/validaEmail")
	public ModelAndView validaEmail(@RequestParam("usuarioEmail") String email) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("usuario/emailValidado");
		Usuario usuario = usuarioServiceImpl.findByEmail(email);
		usuario.setStatus(1);
		mv.addObject("usuario", usuarioServiceImpl.findByEmail(usuario.getEmail()));
		usuarioServiceImpl.edit(usuario);
		return mv;
	}

	@GetMapping("/usuarios")
	public ModelAndView listaUsuario() {
		ModelAndView mv = new ModelAndView("usuario/tabelaUsuario");
		mv.addObject("usuarioLogado", usuarioServiceImpl.usuarioLogado());
		mv.addObject("usuarios", usuarioServiceImpl.searchAll());
		//mv.addObject("curriculos", curriculosService.searchAll());
		return mv;
	}
/*
	@GetMapping("/responsaveis")
	public ModelAndView listaResponsavel() throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("responsavel/tabelaResponsavel");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMINEMP"))
				|| auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_EMP"))) {

			mv.addObject("responsaveis", responsavelServiceImpl.findAllByEmpresa(empresaServiceImpl.searchEmpresaById()));

		} else {

			mv.addObject("responsaveis", responsavelServiceImpl.searchAll());
		}
		return mv;
	}
*/
	@GetMapping("/cadastraUsuario")
	public ModelAndView formCadastraUsuario() throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("usuario/cadastraUsuario");
		mv.addObject("usuarioLogado", usuarioServiceImpl.usuarioLogado());
		mv.addObject("politicaLgpd", politicaLgpdServiceImpl.searchAll());
		mv.addObject("candidaturas", candidaturaServiceImpl.searchAll());
		mv.addObject("curriculos", curriculoServiceImpl.buscarTudo());
		mv.addObject("eventoUsuarios", eventoUsuarioServiceImpl.buscarTodosEventoUsuario());
		mv.addObject("segmentoUsuarios", segmentoUsuarioServiceImpl.buscarTodosSegmentoUsuario());
		mv.addObject("empresas", empresaServiceImpl.searchAll());
		mv.addObject("empresaEmp", empresaServiceImpl.search(empresaServiceImpl.searchEmpresaById().getEmpresaId()));
		mv.addObject("usuario", new Usuario());
		return mv;
	}

	@GetMapping("/alteraUsuario/{id}")
	public ModelAndView alteraUsuario(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("usuario/alteraUsuario");
		mv.addObject("usuarioLogado", usuarioServiceImpl.usuarioLogado());
		mv.addObject("politicaLgpd", politicaLgpdServiceImpl.searchAll());
		mv.addObject("candidaturas", candidaturaServiceImpl.searchAll());
		mv.addObject("curriculos", curriculoServiceImpl.buscarTudo());
		mv.addObject("eventoUsuarios", eventoUsuarioServiceImpl.buscarTodosEventoUsuario());
		mv.addObject("segmentoUsuarios", segmentoUsuarioServiceImpl.buscarTodosSegmentoUsuario());
		mv.addObject("empresas", empresaServiceImpl.searchAll());
		mv.addObject("empresaEmp", empresaServiceImpl.search(empresaServiceImpl.searchEmpresaById().getEmpresaId()));
		mv.addObject("usuario", usuarioServiceImpl.search(id));
		return mv;
	}

	@PostMapping("/alteraSalvaUsuario")
	public ModelAndView alteraSalvaUsuario(Usuario usuario) throws ObjectNotFoundException {
		usuarioServiceImpl.edit(usuario);
		return listaUsuario();
	}

	@PostMapping("/salvaUsuario")
	public ModelAndView salvaUsuario(Usuario usuario)
			throws ObjectNotFoundException, NoSuchAlgorithmException, UnsupportedEncodingException, MessagingException {
		ModelAndView mv;
		emailServiceImpl.sendMail(usuario.getEmail(), "Feira Virtual Senac RJ");
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		usuarioServiceImpl.save(usuario);
		if (usuarioServiceImpl.usuarioLogado() == null) {
			mv = new ModelAndView("usuario/confirmaEmail");
			return mv.addObject("usuario", usuarioServiceImpl.findByCpf(usuario.getCpf()));
		} else {
			mv = new ModelAndView("usuario/confirmaEmailUsuario");
			return mv.addObject("usuario", usuarioServiceImpl.findByCpf(usuario.getCpf()));
		}
	}
}