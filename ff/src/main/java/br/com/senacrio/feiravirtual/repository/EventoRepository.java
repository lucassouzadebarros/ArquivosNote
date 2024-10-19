package br.com.senacrio.feiravirtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.senacrio.feiravirtual.domain.Evento;
import br.com.senacrio.feiravirtual.domain.Stand;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
	
	@Query(value="select e from Evento e where e.eventoStatus= 1 and eventoDataFim > NOW()")
	List<Evento>buscaAtivos();
	

	
	@Query("SELECT ev FROM Evento ev where evento_status not in (0) and stand_id in (:stand) and eventoDataFim > NOW()")
	List<Evento> findAllBystandIn(@Param("stand") List<Stand> stand);
	
	

}



