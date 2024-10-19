package br.com.senacrio.feiravirtual.repository;


import br.com.senacrio.feiravirtual.domain.Empresa;
import br.com.senacrio.feiravirtual.domain.Stand;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StandRepository extends JpaRepository<Stand, Integer> {

	List<Stand> findByempresa(Empresa empresa);
	
	
	@Query("select st from Stand st where stand_status not in (0) and empresa_id = 17")
	List<Stand> BuscaEmpresa(@Param("empresa") Integer empresa_id);
}
