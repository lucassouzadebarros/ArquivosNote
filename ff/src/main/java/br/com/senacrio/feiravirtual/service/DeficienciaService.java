package br.com.senacrio.feiravirtual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senacrio.feiravirtual.domain.Deficiencia;
import br.com.senacrio.feiravirtual.repository.DeficienciaRepository;

@Service
public class DeficienciaService {

    @Autowired
    DeficienciaRepository defRepo;

    public List<Deficiencia> buscaTudo(){
        return defRepo.findAll();
    }



}