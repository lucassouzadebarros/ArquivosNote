package br.com.senacrio.feiravirtual.controllers;

import br.com.senacrio.feiravirtual.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.senacrio.feiravirtual.domain.CurriculoNivelInstrucao;
import br.com.senacrio.feiravirtual.domain.Evento;
import br.com.senacrio.feiravirtual.domain.Palestrante;
import br.com.senacrio.feiravirtual.domain.Responsavel;
import br.com.senacrio.feiravirtual.repository.PalestranteRepository;
import javassist.tools.rmi.ObjectNotFoundException;


@Controller
@RequestMapping("/evento")
public class EventoController {

    Logger logger = LoggerFactory.getLogger(EventoController.class);

    @Autowired
    private EventoService eventoService;
    
    @Autowired
    private EventoTipoService eventoTipoService;
    
    @Autowired
    private StandService standService;

    @Autowired
    private EventoUsuarioService eventoUsuarioService;

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private ResponsavelService responsavelservice;
    
    @Autowired
    private PalestranteRepository palestranterep;

    @GetMapping("/listar")
    public ModelAndView listAll() throws ObjectNotFoundException{
        logger.info("Request received on [GET][/evento]");

        ModelAndView mv = new ModelAndView("/evento/listar");
        mv.addObject("eventoDomainList", eventoService.BuscaEvento());

        logger.info("Returning view to the client");
        return mv;
    }
    
    
    @GetMapping(value = "/palestrante/{id}", produces = "application/json")
    public ResponseEntity<List<Palestrante>> buscarPalestrante(@PathVariable("id") int id) throws ObjectNotFoundException {

        //List<Palestrante> palestrante = new ArrayList<>();
        Evento 			    evento      = new Evento();
        				    evento      = eventoService.find(id);
        				  
    	
    	List<Palestrante> palestrante = new ArrayList<>();
    	palestrante = palestranterep.buscapale(evento);
    	//return ((ResponseEntity<List<Palestrante>>) palestrante, HttpStatus.OK);
        return new ResponseEntity<List<Palestrante>>(new ArrayList<>(palestrante), HttpStatus.OK);
    }
    
    @GetMapping("/cadastrar")
    public ModelAndView create() throws ObjectNotFoundException {
    	logger.info("Request received on [GET][/evento/cadastrar]");
    	
    	ModelAndView mv = new ModelAndView("/evento/cadastrar");
    	mv.addObject("eventoDomain", new Evento());
    	mv.addObject("eventoTipoDomainList", eventoTipoService.findAll());
      	mv.addObject("responDomainList", responsavelservice.searchAll());
    	mv.addObject("standDomainList", standService.Stand());
    	
    	logger.info("Returning view to the client");
    	return mv;
    }
    
    @PostMapping("/salvar")
    public String save(Evento eventoDomain) {
    	logger.info("Request received on [GET][/evento/salvar]");
    	
    	Evento            evento = new Evento();
    	                  evento = eventoService.save(eventoDomain);
    	List<Responsavel> List = new ArrayList<Responsavel>();
    					  List = eventoDomain.getPalestrante();
    					  
    					    
    	for (Responsavel responsavel : List) {
			
    		Palestrante palestrante = new Palestrante();
    		            palestrante.setResp_id(responsavel);
    		            palestrante.setEvento(evento);
    		            
    		palestranterep.save(palestrante);
		}
    	
    	logger.info("Returning view to the client");
    	return "redirect:/evento/listar";
    }
    
    @GetMapping("/atualizar/{id}")
    public ModelAndView updateEvento(@PathVariable("id") Integer id) throws ObjectNotFoundException {
    	logger.info("Request received on [GET][/evento/atualizar/" + id + "]" );
    	
    	ModelAndView mv = new ModelAndView("/evento/atualizar");
    	mv.addObject("eventoDomain", eventoService.find(id));
    	mv.addObject("eventoTipoDomainList", eventoTipoService.findAll());
//    	mv.addObject("standDomainList", standService.buscarTodosStands());
    	mv.addObject("standDomainList", standService.Stand());
    	
    	logger.info("Returning view to the client");
    	return mv;
    }
    
    @PostMapping("/atualizar")
    public String update(Evento eventoDomain) throws ObjectNotFoundException {
    	logger.info("Request received on [POST][/evento/update]");
    	eventoService.update(eventoDomain);
    	
    	return "redirect:/evento/listar";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) throws ObjectNotFoundException {
    	logger.info("Request received on [GET][/evento/delete/{id}]");
    	
    	eventoService.delete(id);
    	
    	logger.info("Returning view to the client");
    	return "redirect:/evento/listar";
    }
    
    @GetMapping("/relatorios")
    public ModelAndView relatorios() {
    	logger.info("Request received on [GET][/relatorios]");
    	
    	ModelAndView mv = new ModelAndView("/evento/relatorios");
        mv.addObject("eventoUsuarioDomainList", eventoUsuarioService.buscarTodosEventoUsuario());
        logger.info("Returning view to the client");
    	return mv;
    }
    
    @GetMapping("/inscricao")
    public ModelAndView inscricao() {
    	logger.info("Request received on [GET][/inscricao]");
    	
    	ModelAndView mv = new ModelAndView("/evento/inscricao");
    	mv.addObject("eventoTipoDomainList", eventoTipoService.findAll());
    	
    	logger.info("Returning view to the client");
    	return mv;
    }
}
