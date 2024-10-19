package br.com.senacrio.feiravirtual.repository;


import br.com.senacrio.feiravirtual.domain.EventoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoUsuarioRepository extends JpaRepository<EventoUsuario, Integer> {
}
