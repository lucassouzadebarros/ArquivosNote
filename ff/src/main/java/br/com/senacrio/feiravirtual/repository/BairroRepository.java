package br.com.senacrio.feiravirtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senacrio.feiravirtual.domain.Bairro;
import br.com.senacrio.feiravirtual.domain.Cidade;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Integer> {

    List<Bairro> findByCidade(Cidade estado);

}