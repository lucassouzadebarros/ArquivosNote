package br.com.senacrio.feiravirtual.service;

import br.com.senacrio.feiravirtual.domain.EventoUsuario;
import br.com.senacrio.feiravirtual.repository.EventoUsuarioRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventoUsuarioService {
    private final EventoUsuarioRepository eventoUsuarioRepository;

    public EventoUsuarioService(EventoUsuarioRepository eventoUsuarioRepository) {
        this.eventoUsuarioRepository = eventoUsuarioRepository;
    }

    public Iterable<EventoUsuario> buscarTodosEventoUsuario() {
        Iterable<EventoUsuario> eventoUsuario = eventoUsuarioRepository.findAll();
        return eventoUsuario;
    }

    public EventoUsuario buscaPorID(Integer id) throws ObjectNotFoundException {
        Optional<EventoUsuario> eventoUsuario = eventoUsuarioRepository.findById(id);
        return eventoUsuario.orElseThrow(() -> new ObjectNotFoundException("EventoUsuario não encontrado. id: " +id));
    }

    public EventoUsuario salvar(EventoUsuario eventoUsuario) {
        return eventoUsuarioRepository.save(eventoUsuario);
    }

    public void excluir(int id) throws ObjectNotFoundException {
        EventoUsuario stand = buscaPorID(id);
        stand.setStatus(-1);
        salvar(stand);
    }

    public EventoUsuario salvarAlteracao(EventoUsuario eventoUsuarioA) throws ObjectNotFoundException {
        EventoUsuario eventoUsuario = buscaPorID(eventoUsuarioA.getId());
        eventoUsuario.setId(eventoUsuarioA.getId());
        eventoUsuario.setDataRegistro(eventoUsuarioA.getDataRegistro());
        eventoUsuario.setLinkCertificado(eventoUsuarioA.getLinkCertificado());
        eventoUsuario.setStatus(eventoUsuarioA.getStatus());
        eventoUsuario.setUsuario(eventoUsuarioA.getUsuario());
        eventoUsuario.setEvento(eventoUsuarioA.getEvento());
        return salvar(eventoUsuario);
    }
}
