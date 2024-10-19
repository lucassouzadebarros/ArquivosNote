package br.com.senacrio.feiravirtual.repository;


import br.com.senacrio.feiravirtual.domain.Candidatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidaturaRepository extends JpaRepository<Candidatura, Integer> {
}
