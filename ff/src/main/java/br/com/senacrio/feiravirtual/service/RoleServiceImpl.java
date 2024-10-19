package br.com.senacrio.feiravirtual.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senacrio.feiravirtual.domain.Role;
import br.com.senacrio.feiravirtual.repository.RoleRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository repository;

	public Role search(String string) throws ObjectNotFoundException {
		Optional<Role> role = repository.findByNomeRole(string);

		return role.orElseThrow(
				() -> new ObjectNotFoundException("não encontrado. id: " + string + ", Tipo!" + Role.class.getName()));
	}

	public List<Role> searchAll() {
		return repository.findAll();
	}

	public Role save(Role role) {
		return repository.save(role);
	}

	public Role edit(Role role) throws ObjectNotFoundException {
		Role roleAntiga = search(role.getNomeRole());
		roleAntiga.setNomeRole(role.getNomeRole());
		roleAntiga.setUsuarios(role.getUsuarios());
		return save(roleAntiga);
	}
}