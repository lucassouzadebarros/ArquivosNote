package br.com.senacrio.feiravirtual.repository;

import br.com.senacrio.feiravirtual.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
