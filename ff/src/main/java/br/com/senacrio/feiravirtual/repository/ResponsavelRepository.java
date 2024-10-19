package br.com.senacrio.feiravirtual.repository;

import br.com.senacrio.feiravirtual.domain.Empresa;
import br.com.senacrio.feiravirtual.domain.Responsavel;
import br.com.senacrio.feiravirtual.domain.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Integer>{
    Responsavel findByEmpresa(Empresa empresa);

    
    List<Responsavel> findByusuario(Usuario id);
}
