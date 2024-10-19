package br.com.senacrio.feiravirtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senacrio.feiravirtual.domain.CurriculoInformacaoAdicional;
import br.com.senacrio.feiravirtual.domain.Usuario;

public interface InformacaoAdicionalRepository extends JpaRepository<CurriculoInformacaoAdicional, Integer> {

    List<CurriculoInformacaoAdicional> findByUsuario(Usuario buscaUsuarioAtual);

}