package br.com.senacrio.feiravirtual.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senacrio.feiravirtual.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

	Optional<Role> findByNomeRole(String nomeRole);
}