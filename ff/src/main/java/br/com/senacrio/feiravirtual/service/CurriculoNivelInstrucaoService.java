package br.com.senacrio.feiravirtual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senacrio.feiravirtual.domain.CurriculoNivelInstrucao;
import br.com.senacrio.feiravirtual.repository.CurriculoNivelInstrucaoRepository;

/*
 * @author: Rodrigo dos Santos Moreira
 *
 */

@Service
public class CurriculoNivelInstrucaoService {

    @Autowired
    private CurriculoNivelInstrucaoRepository curriculoNivelInstrucaoRepo;

    public List<CurriculoNivelInstrucao> buscarTodasEscolaridades() {

        return curriculoNivelInstrucaoRepo.findAll();
    }

}