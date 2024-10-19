package br.com.senacrio.feiravirtual.repository;

import br.com.senacrio.feiravirtual.domain.Segmento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SegmentoRepository extends JpaRepository<Segmento, Integer> {
}
