package br.com.senacrio.feiravirtual.configuration;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.senacrio.feiravirtual.domain.Usuario;
import br.com.senacrio.feiravirtual.repository.UsuarioRepository;

@Repository
@Transactional
public class CurrentUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioRepository ur;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException{
        Usuario usuario = ur.findByCpf(login);
        if (usuario == null || usuario.getStatus() == 0) {
            throw new UsernameNotFoundException("Usuário não encontrado ou sem permissão!");
        } else {
            return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
        }
    }
}