package br.com.senacrio.feiravirtual.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.senacrio.feiravirtual.domain.CurriculoDadoPessoal;

public interface CurriculoDadoPessoalRepository extends JpaRepository<CurriculoDadoPessoal, Integer>{


    @Query(value = "select "
            + "B.bairro_nome as `Nome Bairro`, "
            + "count( DP.dado_pessoal_id ) as `Quantidade` "
            + "from dado_pessoal as DP "
            + "JOIN bairro AS B on DP.bairro_bairro_id = B.bairro_id "
            + "where DP.bairro_bairro_id in (:bairro) "
            + "group by B.bairro_nome ", nativeQuery = true)
    List<Map<String, BigInteger>> findBairros(@Param("bairro") List<String> bairro);

}