package br.com.senacrio.feiravirtual.repository;

import br.com.senacrio.feiravirtual.domain.Cidade;
import br.com.senacrio.feiravirtual.domain.Estado;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

    List<Cidade> findByEstado(Estado estado);

}