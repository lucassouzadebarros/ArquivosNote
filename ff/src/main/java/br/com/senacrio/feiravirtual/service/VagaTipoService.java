package br.com.senacrio.feiravirtual.service;

import br.com.senacrio.feiravirtual.domain.VagaTipo;
import br.com.senacrio.feiravirtual.repository.VagaTipoRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VagaTipoService {
    @Autowired
    VagaTipoRepository vagaTipoRepository;

    public VagaTipo search(Integer id) throws ObjectNotFoundException {
        Optional<VagaTipo> vagaTipo = vagaTipoRepository.findById(id);

        return vagaTipo.orElseThrow(() -> new ObjectNotFoundException(
                " Não encontrado. ID solicitado: " + id + ", Tipo: " + VagaTipo.class.getName()));
    }

    public List<VagaTipo> searchAll() {

        return vagaTipoRepository.findAll();
    }

    public Iterable<VagaTipo> buscarTodasVagaTipos() {
        Iterable<VagaTipo> vagaTipo = vagaTipoRepository.findAll();
        return vagaTipo;
    }

    public VagaTipo save(VagaTipo vagaTipo) {
        return vagaTipoRepository.save(vagaTipo);
    }

    public List<VagaTipo> saveAll(List<VagaTipo> vagaTipos) {
        return vagaTipoRepository.saveAll(vagaTipos);
    }

    public VagaTipo edit(VagaTipo em) throws ObjectNotFoundException {
        VagaTipo vagaTipo = search(em.getId());
        vagaTipo.setDescricao(em.getDescricao());
        vagaTipo.setStatus(em.getStatus());
        return save(vagaTipo);
    }

    public void delete(Integer id) {
        vagaTipoRepository.deleteById(id);
    }

}
