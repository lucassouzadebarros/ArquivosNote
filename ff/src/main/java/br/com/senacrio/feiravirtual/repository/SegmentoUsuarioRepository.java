package br.com.senacrio.feiravirtual.repository;


import br.com.senacrio.feiravirtual.domain.SegmentoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SegmentoUsuarioRepository extends JpaRepository<SegmentoUsuario, Integer> {
}
