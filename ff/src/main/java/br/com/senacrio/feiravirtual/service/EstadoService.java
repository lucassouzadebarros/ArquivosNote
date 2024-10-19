package br.com.senacrio.feiravirtual.service;

import br.com.senacrio.feiravirtual.domain.Estado;
import br.com.senacrio.feiravirtual.repository.EstadoRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {
    @Autowired
    EstadoRepository estadoRepository;

    public Estado search(Integer id) throws ObjectNotFoundException {
        Optional<Estado> estado = estadoRepository.findById(id);

        return estado.orElseThrow(() -> new ObjectNotFoundException(
                " Não encontrado. ID solicitado: " + id + ", Tipo: " + Estado.class.getName()));
    }

    public List<Estado> searchAll() {

        return estadoRepository.findAll();
    }

    public Iterable<Estado> buscarTodasEmpresas() {
        Iterable<Estado> estado = estadoRepository.findAll();
        return estado;
    }

    public Estado save(Estado estado) {
        return estadoRepository.save(estado);
    }

    public List<Estado> saveAll(List<Estado> estados) {
        return estadoRepository.saveAll(estados);
    }

    public Estado edit(Estado em) throws ObjectNotFoundException {
        Estado estado = search(em.getId());
        estado.setNome(em.getNome());
        estado.setStatus(em.getStatus());

        return save(estado);
    }

    public void delete(Integer id) {
        estadoRepository.deleteById(id);
    }
}
