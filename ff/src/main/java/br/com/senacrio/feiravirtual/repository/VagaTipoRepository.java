package br.com.senacrio.feiravirtual.repository;

import br.com.senacrio.feiravirtual.domain.VagaTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaTipoRepository extends JpaRepository<VagaTipo, Integer> {
}
