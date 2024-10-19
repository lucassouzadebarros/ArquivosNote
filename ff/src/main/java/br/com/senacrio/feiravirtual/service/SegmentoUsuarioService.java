package br.com.senacrio.feiravirtual.service;

import br.com.senacrio.feiravirtual.domain.SegmentoUsuario;
import br.com.senacrio.feiravirtual.repository.SegmentoUsuarioRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SegmentoUsuarioService {
    private final SegmentoUsuarioRepository segmentoUsuarioRepository;

    public SegmentoUsuarioService(SegmentoUsuarioRepository segmentoUsuarioRepository) {
        this.segmentoUsuarioRepository = segmentoUsuarioRepository;
    }

    public Iterable<SegmentoUsuario> buscarTodosSegmentoUsuario() {
        Iterable<SegmentoUsuario> segmentoUsuario = segmentoUsuarioRepository.findAll();
        return segmentoUsuario;
    }

    public SegmentoUsuario buscaPorID(Integer id) throws ObjectNotFoundException {
        Optional<SegmentoUsuario> segmentoUsuario = segmentoUsuarioRepository.findById(id);
        return segmentoUsuario.orElseThrow(() -> new ObjectNotFoundException("SegmentoUsuario não encontrado. id: " +id));
    }

    public SegmentoUsuario salvar(SegmentoUsuario eventoUsuario) {
        return segmentoUsuarioRepository.save(eventoUsuario);
    }

    public void excluir(int id) throws ObjectNotFoundException {
        segmentoUsuarioRepository.deleteById(id);
    }

    public SegmentoUsuario salvarAlteracao(SegmentoUsuario segmentoUsuarioA) throws ObjectNotFoundException {
        SegmentoUsuario segmentoUsuario = buscaPorID(segmentoUsuarioA.getId());
        segmentoUsuarioA.setId(segmentoUsuarioA.getId());
        segmentoUsuarioA.setUsuario(segmentoUsuarioA.getUsuario());
        segmentoUsuarioA.setSegmento(segmentoUsuarioA.getSegmento());
        return salvar(segmentoUsuarioA);
    }
}
