package br.com.senacrio.feiravirtual.service;

import br.com.senacrio.feiravirtual.domain.Usuario;
import br.com.senacrio.feiravirtual.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UsuarioRepository usuarioCat;

    public boolean login(Usuario usuario){
        Usuario usuarioEncontrado = usuarioCat.findByCpfAndSenha(usuario.getCpf(), usuario.getSenha());
        if (usuarioEncontrado== null)
            return false;
        return true;
    }

}
