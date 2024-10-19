package br.com.senacrio.feiravirtual.repository;

import br.com.senacrio.feiravirtual.domain.AcessoUsuario;
import br.com.senacrio.feiravirtual.domain.Stand;
import br.com.senacrio.feiravirtual.domain.Usuario;
import br.com.senacrio.feiravirtual.domain.dto.Relatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcessoUsuarioRepository extends JpaRepository<AcessoUsuario, Integer>{

    @Query(value = "SELECT new br.com.senacrio.feiravirtual.domain.dto.Relatorio(COUNT(au), au.data, au.stand) from AcessoUsuario au WHERE au.stand = :stand GROUP BY au.data")
    List<Relatorio> quantosUsuariosPorDiaNoStand(@Param("stand") Stand stand);

    @Query(value = "SELECT new br.com.senacrio.feiravirtual.domain.dto.Relatorio(COUNT(au), au.data, au.stand) from AcessoUsuario au GROUP BY au.data")
    List<Relatorio> quantosUsuariosPorDia();

    List<AcessoUsuario> findAllByUsuario(Usuario usuario);
}