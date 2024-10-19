package br.com.senacrio.feiravirtual.repository;

import br.com.senacrio.feiravirtual.domain.AreaAtuacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaAtuacaoRepository extends JpaRepository<AreaAtuacao, Integer> {
}
