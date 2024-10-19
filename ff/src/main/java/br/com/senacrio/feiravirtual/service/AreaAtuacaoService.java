package br.com.senacrio.feiravirtual.service;

import br.com.senacrio.feiravirtual.domain.AreaAtuacao;
import br.com.senacrio.feiravirtual.repository.AreaAtuacaoRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaAtuacaoService {
    @Autowired
    AreaAtuacaoRepository areaAtuacaoRepository;

    public AreaAtuacao search(Integer id) throws ObjectNotFoundException {
        Optional<AreaAtuacao> areaAtuacao = areaAtuacaoRepository.findById(id);

        return areaAtuacao.orElseThrow(() -> new ObjectNotFoundException(
                " Não encontrado. ID solicitado: " + id + ", Tipo: " + AreaAtuacao.class.getName()));
    }

    public List<AreaAtuacao> searchAll() {

        return areaAtuacaoRepository.findAll();
    }

    public Iterable<AreaAtuacao> buscarTodasAreasAtuacao() {
        Iterable<AreaAtuacao> areaAtuacao = areaAtuacaoRepository.findAll();
        return areaAtuacao;
    }

    public AreaAtuacao save(AreaAtuacao areaAtuacao) {
        return areaAtuacaoRepository.save(areaAtuacao);
    }

    public List<AreaAtuacao> saveAll(List<AreaAtuacao> areasAtuacao) {
        return areaAtuacaoRepository.saveAll(areasAtuacao);
    }

    public AreaAtuacao edit(AreaAtuacao em) throws ObjectNotFoundException {
        AreaAtuacao areaAtuacao = search(em.getId());
        areaAtuacao.setDescricao(em.getDescricao());
        areaAtuacao.setStatus(em.getStatus());
        return save(areaAtuacao);
    }

    public void delete(Integer id) {
        areaAtuacaoRepository.deleteById(id);
    }

}
