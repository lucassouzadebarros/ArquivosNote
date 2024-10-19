package br.com.senacrio.feiravirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senacrio.feiravirtual.domain.EtapaProcesso;

@Repository
public interface EtapaProcessoRepository extends JpaRepository<EtapaProcesso, Integer> {

}