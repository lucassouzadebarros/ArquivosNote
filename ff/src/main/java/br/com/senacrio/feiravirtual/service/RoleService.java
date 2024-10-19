package br.com.senacrio.feiravirtual.service;

import java.util.List;

import br.com.senacrio.feiravirtual.domain.Role;
import javassist.tools.rmi.ObjectNotFoundException;

public interface RoleService {

	Role search(String id) throws ObjectNotFoundException;

	List<Role> searchAll();

	Role save(Role role);

	Role edit(Role role) throws ObjectNotFoundException;
}