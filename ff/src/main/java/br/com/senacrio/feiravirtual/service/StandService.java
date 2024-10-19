package br.com.senacrio.feiravirtual.service;

import br.com.senacrio.feiravirtual.domain.Empresa;
import br.com.senacrio.feiravirtual.domain.Responsavel;
import br.com.senacrio.feiravirtual.domain.Stand;
import br.com.senacrio.feiravirtual.domain.Usuario;
import br.com.senacrio.feiravirtual.repository.StandRepository;
import javassist.tools.rmi.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class StandService {

	@Autowired
	ResponsavelService responsavelservice;
	@Autowired
	UsuarioServiceImpl usuarioservice;
	
	private final StandRepository standRepository;

	public StandService(StandRepository standRepository) {
		this.standRepository = standRepository;
	}

	public Iterable<Stand> buscarTodosStands() {
		Iterable<Stand> stand = standRepository.findAll();
		return stand;
	}

	public Stand buscaPorID(Integer id) throws ObjectNotFoundException{
		Optional<Stand> stand = standRepository.findById(id);
		return stand.orElseThrow(() -> new ObjectNotFoundException("Stand não encontrado. id: " +id));
	}

	public Stand salvar(Stand stand) {
		return standRepository.save(stand);
	}

	public void excluir(int id) throws ObjectNotFoundException {
		Stand stand = buscaPorID(id);
		stand.setStandStatus(false);
		salvar(stand);
	}

	public Stand salvarAlteracao(Stand standAlterado) throws ObjectNotFoundException {
		Stand stand = buscaPorID(standAlterado.getStandId());
		stand.setStandId(standAlterado.getStandId());
		stand.setStandNome(standAlterado.getStandNome());
		stand.setStandLinkApresentacao(standAlterado.getStandLinkApresentacao());
		stand.setStandLinkChat(standAlterado.getStandLinkChat());
		stand.setStandStatus(standAlterado.getStandStatus());
		stand.setStandLinkLogomarca(standAlterado.getStandLinkLogomarca());
		stand.setEmpresa(standAlterado.getEmpresa());
		return salvar(stand);
	}
	

	//Buscando os Stands de acordo com o usuário logado//
	    public List<Stand> Stand() throws ObjectNotFoundException {
	       
	//
	         int cont;
	         cont =0;
	         String acesso;
	         
	         List<Stand> StandDomainList   = new ArrayList<Stand>();  
	         List<Stand> StandDomainListt  = new ArrayList<Stand>(); 
	         Usuario     usermodel         = usuarioservice.usuarioLogado();
	         acesso = usermodel.getNomeCompleto();
	         
	         if(acesso.equalsIgnoreCase("Teste Administrador Senac") ) {
	        	 StandDomainListt = (List<br.com.senacrio.feiravirtual.domain.Stand>) buscarTodosStands();
	        	 return StandDomainListt;
	         }
	         else {
	         
	         List<Responsavel> responmodel = new ArrayList<Responsavel>();        
	                           responmodel = (List<Responsavel>) responsavelservice.findAllByEmpresaUsu(usermodel);
	         
	         for (Responsavel responsavel : responmodel) {
	        	 cont +=1;
	        	 
			}
	       
	         if(cont == 1) {
	        	 
	        	 for (Responsavel responsavel : responmodel) {
	        		 int emp2;
	        		 Empresa     emp         = new Empresa();
	        		 emp                     = responsavel.getEmpresa();
	                 StandDomainListt = (List<br.com.senacrio.feiravirtual.domain.Stand>) standRepository.findByempresa(emp);
	                 return StandDomainListt;
	    		}
	        	 
	         }else { 
	        	 StandDomainListt = (List<br.com.senacrio.feiravirtual.domain.Stand>) buscarTodosStands();
	        	 return StandDomainListt;
	         }
	        
	         return StandDomainListt;
	       
	    }
	    }

}
