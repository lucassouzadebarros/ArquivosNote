package br.com.senacrio.feiravirtual.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.senacrio.feiravirtual.domain.Bairro;
import br.com.senacrio.feiravirtual.domain.Cidade;
import br.com.senacrio.feiravirtual.repository.BairroRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class BairroService {
    private final BairroRepository bairroRepository;

    public BairroService(BairroRepository bairroRepository) {
        this.bairroRepository = bairroRepository;
    }

    public Iterable<Bairro> buscarTodosBairros() {
        Iterable<Bairro> bairro = bairroRepository.findAll();
        return bairro;
    }

    public Bairro buscaPorID(Integer id) throws ObjectNotFoundException {
        Optional<Bairro> bairro = bairroRepository.findById(id);
        return bairro.orElseThrow(() -> new ObjectNotFoundException("Bairro não encontrado. id: " +id));
    }

    public List<Bairro> buscaPorCidade(Cidade cidade) throws ObjectNotFoundException {
        return bairroRepository.findByCidade(cidade);
    }

    public Bairro salvar(Bairro bairro) {
        return bairroRepository.save(bairro);
    }

    public void excluir(int id) throws ObjectNotFoundException {
        Bairro bairro = buscaPorID(id);
        bairro.setStatus(-1);
        salvar(bairro);
    }

    public Bairro salvarAlteracao(Bairro bairroAlterado) throws ObjectNotFoundException {
        Bairro bairro = buscaPorID(bairroAlterado.getId());
        bairro.setId(bairroAlterado.getId());
        bairro.setNome(bairroAlterado.getNome());
        bairro.setStatus(bairroAlterado.getStatus());
        bairro.setCidade(bairroAlterado.getCidade());
        return salvar(bairro);
    }
}