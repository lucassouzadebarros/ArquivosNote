package br.com.senacrio.feiravirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senacrio.feiravirtual.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByCpf(String cpf);
	Usuario findByEmail(String email);
	Usuario findByCpfAndSenha(String cpf, String senha);

}