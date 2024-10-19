package br.com.senacrio.feiravirtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senacrio.feiravirtual.domain.CurriculoExperienciaProfissional;
import br.com.senacrio.feiravirtual.domain.Usuario;

public interface ExperienciaProfissionalRepository extends JpaRepository<CurriculoExperienciaProfissional, Integer> {

    List<CurriculoExperienciaProfissional> findByUsuario(Usuario buscaUsuarioAtual);

}