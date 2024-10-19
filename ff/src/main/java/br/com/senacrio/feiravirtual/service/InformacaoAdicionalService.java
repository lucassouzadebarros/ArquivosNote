package br.com.senacrio.feiravirtual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.senacrio.feiravirtual.domain.CurriculoFormacaoAcademica;
import br.com.senacrio.feiravirtual.domain.CurriculoInformacaoAdicional;
import br.com.senacrio.feiravirtual.domain.Usuario;
import br.com.senacrio.feiravirtual.repository.FormacaoAcademicaRepository;
import br.com.senacrio.feiravirtual.repository.InformacaoAdicionalRepository;

@Service
public class InformacaoAdicionalService {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @Autowired
    InformacaoAdicionalRepository infoAdiciRepo;


    public List<CurriculoInformacaoAdicional> findByUsuario(){
        return infoAdiciRepo.findByUsuario(buscaUsuarioAtual());
    }


    private Usuario buscaUsuarioAtual() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario user = usuarioService.findByCpf(name);
        return user;
    }

}