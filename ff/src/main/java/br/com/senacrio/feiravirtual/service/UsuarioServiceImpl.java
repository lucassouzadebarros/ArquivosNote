package br.com.senacrio.feiravirtual.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.senacrio.feiravirtual.domain.Usuario;
import br.com.senacrio.feiravirtual.repository.UsuarioRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Usuario search(Integer id) throws ObjectNotFoundException {
		Optional<Usuario> usuario = repository.findById(id);

		return usuario.orElseThrow(
				() -> new ObjectNotFoundException("não encontrado. id: " + id + ", Tipo!" + Usuario.class.getName()));
	}

	public Usuario findByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}

	public Usuario findByEmail(String usuarioEmail) {
		return repository.findByEmail(usuarioEmail);
	}
	
	public List<Usuario> searchAll() {
		return repository.findAll();
	}

	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}

	public Usuario edit(Usuario usuario) throws ObjectNotFoundException {
		Usuario usuarioAntigo = search(usuario.getId());
		usuarioAntigo.setCpf(usuario.getCpf());
		usuarioAntigo.setNomeCompleto(usuario.getNomeCompleto());
		usuarioAntigo.setStatuspoliticaLgpd(usuario.getStatuspoliticaLgpd());
		usuarioAntigo.setPoliticaLgpd(usuario.getPoliticaLgpd());
		usuarioAntigo.setEmail(usuario.getEmail());
		usuarioAntigo.setTelefone(usuario.getTelefone());
		usuarioAntigo.setSenac(usuario.getSenac());
		usuarioAntigo.setStatus(usuario.getStatus());
		if(usuario.isTrocaSenha()){
			usuarioAntigo.setSenha(new BCryptPasswordEncoder().encode("senac"));
		}
		return save(usuarioAntigo);
	}

	public Usuario usuarioLogado() {
		String cpf = SecurityContextHolder.getContext().getAuthentication().getName();
		//Usuario usuario = this.findByEmail(email);
		Usuario usuario = this.findByCpf(cpf);
		return usuario;
	}

}