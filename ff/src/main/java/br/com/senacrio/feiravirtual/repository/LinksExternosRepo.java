package br.com.senacrio.feiravirtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senacrio.feiravirtual.domain.CurriculoLinkExterno;
import br.com.senacrio.feiravirtual.domain.Usuario;

public interface LinksExternosRepo extends JpaRepository<CurriculoLinkExterno, Integer> {

    List<CurriculoLinkExterno> findByUsuario(Usuario buscaUsuarioAtual);

}