package br.com.senacrio.feiravirtual.service;

import br.com.senacrio.feiravirtual.domain.Empresa;
import br.com.senacrio.feiravirtual.domain.Evento;
import br.com.senacrio.feiravirtual.domain.Responsavel;
import br.com.senacrio.feiravirtual.domain.Stand;
import br.com.senacrio.feiravirtual.domain.Usuario;
import br.com.senacrio.feiravirtual.repository.EventoRepository;
import br.com.senacrio.feiravirtual.repository.StandRepository;
import javassist.tools.rmi.ObjectNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.Jsr310Converters.StringToLocalDateTimeConverter;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class EventoService {

    Logger logger = LoggerFactory.getLogger(EventoService.class);

    private final EventoRepository eventoRepository;
    
    private final StandService standRepository;
    
    private final StandRepository standrepo;
    
    private final UsuarioServiceImpl userservice;
    
    private final ResponsavelService responserv;
    

    private final StandService standservice;

    @Autowired
    public EventoService(EventoRepository eventoRepository, StandService standRepository, UsuarioServiceImpl userservice, ResponsavelService responserv, StandRepository standrepo,StandService standservice) {
        this.eventoRepository = eventoRepository;
		this.standRepository = standRepository;
		this.standrepo = standrepo;
		this.userservice = userservice;
		this.responserv = responserv;
		this.standservice = standservice;
    }
    
    public Evento find(Integer id) throws ObjectNotFoundException {
    	logger.info("Finding [EventoDomain] id: " + id + "");
    	
    	Optional<Evento> eventoDomain = eventoRepository.findById(id);
    	
    	logger.info("Returning [EventoDomain] id: " + id + "");
    	return eventoDomain.orElseThrow(() -> new ObjectNotFoundException(
    			"not found, id: " + id + "Tipe: " + Evento.class.getName()));
    }

    public List<Evento> findAll() {
        logger.info("Finding all [EventoDomain] on Database");

        List<Evento> eventoDomainList = this.eventoRepository.findAll();

        logger.info("Returning [EventoDomain] List");
        return eventoDomainList;
    }
    
    
    public List<Evento> BuscaEvento() throws ObjectNotFoundException {
       
         
       Evento evento = new Evento();
       List<Evento> eventlist = eventoRepository.findAllBystandIn(standservice.Stand());

        logger.info("Returning [EventoDomain] List");
        return eventlist;
    }
    


    public List<Evento> listAtivos(){
    	
        logger.info("Finding all [EventoDomain] on Database");
        List<Evento> eventoDomainList = this.eventoRepository.buscaAtivos();

        logger.info("Returning [EventoDomain] List");
        return eventoDomainList;

    }
    public Evento save(Evento eventoDomain) {
        logger.info("Saving [EventoDomain] on Database");

        Evento eventoDomainFromDb = this.eventoRepository.save(eventoDomain);

        logger.info("Returning [EventoDomain] saved on Database");
        return eventoDomainFromDb;
    }
    
    public Evento update(Evento eventoDomain) throws ObjectNotFoundException {
    	logger.info("Updating [EventoDomain] attributes");
    	
    	Evento oldEventoDomain = find(eventoDomain.getId());
    	oldEventoDomain.setEventoTitulo(eventoDomain.getEventoTitulo());
    	oldEventoDomain.setEventoTipo(eventoDomain.getEventoTipo());
    	oldEventoDomain.setEventoDataInicio(eventoDomain.getEventoDataInicio());
        oldEventoDomain.setEventoDataFim(eventoDomain.getEventoDataFim());
    	oldEventoDomain.setEventoLink(eventoDomain.getEventoLink());
    	oldEventoDomain.setEventoLinkBanner(eventoDomain.getEventoLinkBanner());
    	oldEventoDomain.setEventoVagas(eventoDomain.getEventoVagas());
    	oldEventoDomain.setStand(eventoDomain.getStand());
    	oldEventoDomain.setEventoStatus(eventoDomain.getEventoStatus());
    	
    	return save(oldEventoDomain);
    }
    
    public void delete(Integer id) throws ObjectNotFoundException {
    	logger.info("Deleting [EventoDomain], id: " + id);
    	Evento oldEventoDomain = find(id);
       	oldEventoDomain.setEventoStatus(0);
       	save(oldEventoDomain);
    	    	
    }
}
