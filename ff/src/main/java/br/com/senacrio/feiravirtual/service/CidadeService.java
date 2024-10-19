package br.com.senacrio.feiravirtual.service;

import br.com.senacrio.feiravirtual.domain.Cidade;
import br.com.senacrio.feiravirtual.domain.Estado;
import br.com.senacrio.feiravirtual.repository.CidadeRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CidadeService {
    private final CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public Iterable<Cidade> buscarTodasCidades() {
        Iterable<Cidade> cidade = cidadeRepository.findAll();
        return cidade;
    }

    public List<Cidade> buscarTodasCidadesPorEstado(Estado estado) {
        return cidadeRepository.findByEstado(estado);
    }

    public Cidade buscaPorID(Integer id) throws ObjectNotFoundException {
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        return cidade.orElseThrow(() -> new ObjectNotFoundException("Cidade não encontrada. id: " +id));
    }

    public Cidade salvar(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    public void excluir(int id) throws ObjectNotFoundException {
        Cidade cidade = buscaPorID(id);
        cidade.setStatus(-1);
        salvar(cidade);
    }

    public Cidade salvarAlteracao(Cidade bairroAlterado) throws ObjectNotFoundException {
        Cidade cidade = buscaPorID(bairroAlterado.getId());
        cidade.setId(bairroAlterado.getId());
        cidade.setNome(bairroAlterado.getNome());
        cidade.setStatus(bairroAlterado.getStatus());
        cidade.setEstado(bairroAlterado.getEstado());
        return salvar(cidade);
    }
}