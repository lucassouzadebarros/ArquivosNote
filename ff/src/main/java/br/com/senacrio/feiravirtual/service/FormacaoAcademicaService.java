package br.com.senacrio.feiravirtual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.senacrio.feiravirtual.domain.CurriculoFormacaoAcademica;
import br.com.senacrio.feiravirtual.domain.Usuario;
import br.com.senacrio.feiravirtual.repository.FormacaoAcademicaRepository;

@Service
public class FormacaoAcademicaService {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @Autowired
    FormacaoAcademicaRepository faRepo;


    public List<CurriculoFormacaoAcademica> findByUsuario(){
        return faRepo.findByUsuario(buscaUsuarioAtual());
    }


    private Usuario buscaUsuarioAtual() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario user = usuarioService.findByCpf(name);
        return user;
    }

}