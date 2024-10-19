package br.com.senacrio.feiravirtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senacrio.feiravirtual.domain.CurriculoFormacaoAcademica;
import br.com.senacrio.feiravirtual.domain.Usuario;

public interface FormacaoAcademicaRepository extends JpaRepository<CurriculoFormacaoAcademica, Integer> {

    List<CurriculoFormacaoAcademica> findByUsuario(Usuario buscaUsuarioAtual);

}