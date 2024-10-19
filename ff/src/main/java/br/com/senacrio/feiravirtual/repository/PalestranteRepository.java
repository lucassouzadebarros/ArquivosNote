package br.com.senacrio.feiravirtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.senacrio.feiravirtual.domain.Evento;
import br.com.senacrio.feiravirtual.domain.Palestrante;
import br.com.senacrio.feiravirtual.domain.Stand;

public interface PalestranteRepository extends JpaRepository<Palestrante, Integer> {

	@Query("SELECT ev FROM Palestrante ev where evento in (:evento)")
	List<Palestrante> buscapale(Evento evento);
	
	//@Query("SELECT ev FROM Evento ev where evento_status not in (0) and stand_id in (:stand)")
	//List<Evento> findAllBystandIn(@Param("stand") List<Stand> stand);

}
