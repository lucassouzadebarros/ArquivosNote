package br.com.senacrio.feiravirtual.service;

import br.com.senacrio.feiravirtual.domain.EventoTipo;
import br.com.senacrio.feiravirtual.repository.EventoTipoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoTipoService {

    Logger logger = LoggerFactory.getLogger(EventoTipoService.class);

    private final EventoTipoRepository eventoTipoRepository;

    @Autowired
    public EventoTipoService(EventoTipoRepository eventoTipoRepository) {
        this.eventoTipoRepository = eventoTipoRepository;
    }
    
    public EventoTipo find(Integer id) throws ObjectNotFoundException {
    	logger.info("Finding [EventoTipoDomain] id: " + id + "");
    	
    	Optional<EventoTipo> eventoTipoDomain = eventoTipoRepository.findById(id);
    	
    	logger.info("Returning [EventoTipoDomain] id: " + id + "");
    	return eventoTipoDomain.orElseThrow(() -> new ObjectNotFoundException(
    			"not found, id: " + id + "Tipe: " + EventoTipo.class.getName()));
    }

    public List<EventoTipo> findAll() {
        logger.info("Finding all [EventoTipoDomain] on Database");

        List<EventoTipo> eventoTipoDomainList = this.eventoTipoRepository.findAll();

        logger.info("Returning [EventoTipoDomain] List");
        return eventoTipoDomainList;
    }

    public EventoTipo save(EventoTipo eventoTipoDomain) {
        logger.info("Saving [EventoTipoDomain] on Database");

        EventoTipo eventoTipoDomainFromDb = this.eventoTipoRepository.save(eventoTipoDomain);

        logger.info("Returning [EventoTipoDomain] saved on Database");
        return eventoTipoDomainFromDb;
    }
    
    public EventoTipo update(EventoTipo eventoTipoDomain) throws ObjectNotFoundException {
    	logger.info("Updating [EventoTipoDomain] attributes");
    	
    	EventoTipo oldEventoTipoDomain = find(eventoTipoDomain.getId());
    	oldEventoTipoDomain.setEventoTipoDescricao(eventoTipoDomain.getEventoTipoDescricao());
    	oldEventoTipoDomain.setEventoTipoStatus(eventoTipoDomain.getEventoTipoStatus());
    	
    	return save(oldEventoTipoDomain);
    }
    
    public void delete(Integer id) {
    	logger.info("Deleting [EventoTipoDomain], id: " + id);
    	eventoTipoRepository.deleteById(id);
    }
}
