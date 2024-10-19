package br.com.senacrio.feiravirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senacrio.feiravirtual.domain.Vaga;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senacrio.feiravirtual.domain.Empresa;
import br.com.senacrio.feiravirtual.domain.Vaga;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Integer>{

    List<Vaga> findAllByEmpresa(Empresa empresa);

}