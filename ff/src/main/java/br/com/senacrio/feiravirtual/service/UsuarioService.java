package br.com.senacrio.feiravirtual.service;

import java.util.List;

import br.com.senacrio.feiravirtual.domain.Usuario;
import javassist.tools.rmi.ObjectNotFoundException;

public interface UsuarioService {

	Usuario findByCpf(String cpf);

	Usuario search(Integer id) throws ObjectNotFoundException;

	List<Usuario> searchAll();

	Usuario save(Usuario usuario);

	Usuario edit(Usuario usuario) throws ObjectNotFoundException;
}