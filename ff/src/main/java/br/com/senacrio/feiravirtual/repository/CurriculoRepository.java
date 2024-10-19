package br.com.senacrio.feiravirtual.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.senacrio.feiravirtual.domain.Curriculo;
import br.com.senacrio.feiravirtual.domain.Usuario;

/**
 *
 * @author João pedro Freitas Barros
 *
 */
@Repository
public interface CurriculoRepository extends JpaRepository<Curriculo, Integer>{

    @Query(value = "SELECT DADO_PESSOAL_DEFICIENTE as DEFICIENCIA, COUNT(DADO_PESSOAL_DEFICIENTE)  as QUANTIDADE "
            + "FROM DADO_PESSOAL " + "GROUP BY DADO_PESSOAL_DEFICIENTE ", nativeQuery = true)
    List<Map<String, BigInteger>> findAllDeficiente();

    @Query(value = "SELECT DADO_PESSOAL_DEFICIENTE as DEFICIENCIA, COUNT(DADO_PESSOAL_DEFICIENTE)  as QUANTIDADE "
            + "FROM DADO_PESSOAL " + "WHERE DADO_PESSOAL_DEFICIENTE = :deficiente "
            + "GROUP BY DADO_PESSOAL_DEFICIENTE ", nativeQuery = true)
    List<Map<String, BigInteger>> findByDeficiente(@Param("deficiente") String deficiente);

    @Query(value = "SELECT NIVEL_INSTRUCAO_DESCRICAO as NIVEL, COUNT(NIVEL_INSTRUCAO_DESCRICAO) as QUANTIDADE "
            + "FROM NIVEL_INSTRUCAO " + "GROUP BY NIVEL_INSTRUCAO_DESCRICAO ", nativeQuery = true)
    List<Map<String, BigInteger>> findAllNivelInstrucao();

    @Query(value = "SELECT NIVEL_INSTRUCAO_DESCRICAO as NIVEL, COUNT(NIVEL_INSTRUCAO_DESCRICAO) as QUANTIDADE "
            + "FROM NIVEL_INSTRUCAO " + "WHERE NIVEL_INSTRUCAO_DESCRICAO = :nivel "
            + "GROUP BY NIVEL_INSTRUCAO_DESCRICAO ", nativeQuery = true)
    List<Map<String, BigInteger>> findByNivelInstrucao(@Param("nivel") String nivel);

    List<Curriculo> findByUsuario(Usuario buscaUsuarioAtual);

    //	@Query()
    //	List<Map<String, BigInteger>> findAllRegiao();

    //	@Query()
    //	List<Map<String, BigInteger>> findByRegiao(
    //			@Param("bairro") String bairro,
    //			@Param("cidade") String cidade,
    //			@Param("estado") String estado);

}