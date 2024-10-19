package br.com.senacrio.feiravirtual.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.senacrio.feiravirtual.domain.CurriculoDadoPessoal;
import br.com.senacrio.feiravirtual.domain.Usuario;
import br.com.senacrio.feiravirtual.repository.CurriculoDadoPessoalRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CurriculoDadoPessoalService {

    @Autowired
    CurriculoDadoPessoalRepository repo;

    @Autowired
    UsuarioServiceImpl usuarioService;

    public CurriculoDadoPessoal buscaPorID(Integer id) throws ObjectNotFoundException {
        Optional<CurriculoDadoPessoal> dadoPessoal = repo.findById(id);
        return dadoPessoal.orElseThrow(() -> new ObjectNotFoundException("Dado pessoal não encontrado. id:" + id));
    }

    public CurriculoDadoPessoal salvar(CurriculoDadoPessoal dadoPessoal) throws ObjectNotFoundException {
        Usuario user = buscaUsuarioAtual();

        user.setDadoPessoal(repo.save(dadoPessoal));
        usuarioService.edit(user);

        return dadoPessoal;
    }

    public CurriculoDadoPessoal dadoPessoal() {
        Usuario user = buscaUsuarioAtual();

        if(user.getDadoPessoal() != null) {
            return user.getDadoPessoal();
        }
        return new CurriculoDadoPessoal();
    }

    private Usuario buscaUsuarioAtual() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario user = usuarioService.findByCpf(name);
        return user;
    }

    @SuppressWarnings("unused")
    public List<Map<String, BigInteger>> listarQuantidadeCurriculosPorBairro(List<String> bairros){
        return repo.findBairros(bairros);
    }

}