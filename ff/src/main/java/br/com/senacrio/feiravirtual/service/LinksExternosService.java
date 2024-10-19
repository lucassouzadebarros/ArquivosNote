package br.com.senacrio.feiravirtual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.senacrio.feiravirtual.domain.CurriculoLinkExterno;
import br.com.senacrio.feiravirtual.domain.Usuario;
import br.com.senacrio.feiravirtual.repository.LinksExternosRepo;

@Service
public class LinksExternosService {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @Autowired
    LinksExternosRepo lksExternosRepo;


    public List<CurriculoLinkExterno> findByUsuario(){
        return lksExternosRepo.findByUsuario(buscaUsuarioAtual());
    }


    private Usuario buscaUsuarioAtual() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario user = usuarioService.findByCpf(name);
        return user;
    }

}