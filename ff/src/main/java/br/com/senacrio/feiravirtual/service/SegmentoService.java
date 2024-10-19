package br.com.senacrio.feiravirtual.service;

import br.com.senacrio.feiravirtual.domain.Segmento;
import br.com.senacrio.feiravirtual.repository.SegmentoRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SegmentoService {

    @Autowired
    SegmentoRepository segmentoRepository;

    public Segmento search(Integer id) throws ObjectNotFoundException {
        Optional<Segmento> segmento = segmentoRepository.findById(id);

        return segmento.orElseThrow(() -> new ObjectNotFoundException(
                " Não encontrado. ID solicitado: " + id + ", Tipo: " + Segmento.class.getName()));
    }

    public List<Segmento> searchAll() {
        return segmentoRepository.findAll();
    }

    public Iterable<Segmento> buscarTodasEmpresas() {
        Iterable<Segmento> empresa = segmentoRepository.findAll();
        return empresa;
    }

    public Segmento save(Segmento segmento) {
        return segmentoRepository.save(segmento);
    }

    public List<Segmento> saveAll(List<Segmento> segmento) {
        return segmentoRepository.saveAll(segmento);
    }

    public Segmento edit(Segmento em) throws ObjectNotFoundException {
        Segmento segmento = search(em.getId());
        segmento.setDescricao(em.getDescricao());
        segmento.setStatus(em.getStatus());
        return save(segmento);
    }

    public void delete(Integer id) {
        segmentoRepository.deleteById(id);
    }

}
