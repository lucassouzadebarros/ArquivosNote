package br.com.senacrio.feiravirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senacrio.feiravirtual.domain.CurriculoNivelInstrucao;

/*
 * @author: Rodrigo dos Santos Moreira
 *
 */

@Repository
public interface CurriculoNivelInstrucaoRepository extends JpaRepository<CurriculoNivelInstrucao, Integer>{

}