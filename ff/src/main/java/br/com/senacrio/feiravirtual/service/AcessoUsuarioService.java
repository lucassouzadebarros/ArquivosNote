package br.com.senacrio.feiravirtual.service;

import br.com.senacrio.feiravirtual.domain.AcessoUsuario;
import br.com.senacrio.feiravirtual.domain.Stand;
import br.com.senacrio.feiravirtual.domain.Usuario;
import br.com.senacrio.feiravirtual.domain.dto.Relatorio;
import br.com.senacrio.feiravirtual.repository.AcessoUsuarioRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcessoUsuarioService {

    private final AcessoUsuarioRepository acessoUsuarioRepository;

    public AcessoUsuarioService(AcessoUsuarioRepository acessoUsuarioRepository) {
        this.acessoUsuarioRepository = acessoUsuarioRepository;
    }

    public Iterable<AcessoUsuario> buscarTodosAcessosUsuario() {
        Iterable<AcessoUsuario> acessoUsuario = acessoUsuarioRepository.findAll();
        return acessoUsuario;
    }

    public Iterable<AcessoUsuario> buscarAcessosUsuarioPorUsuario(Usuario usuario) {
        Iterable<AcessoUsuario> acessoUsuario = acessoUsuarioRepository.findAllByUsuario(usuario);
        return acessoUsuario;
    }

    public AcessoUsuario buscaPorID(Integer id) throws ObjectNotFoundException{
        Optional<AcessoUsuario> acessoUsuario = acessoUsuarioRepository.findById(id);
        return acessoUsuario.orElseThrow(() -> new ObjectNotFoundException("Stand não encontrado. id: " +id));
    }

    public AcessoUsuario salvar(AcessoUsuario acessoUsuario) {
        return acessoUsuarioRepository.save(acessoUsuario);
    }

    //public void excluir(int id) throws ObjectNotFoundException {
    //	AcessoUsuario acessoUsuario = buscaPorID(id);
    //	acessoUsuario.setAcessoUsuarioStatus(false);
    //	salvar(acessoUsuario);
    //}

    public AcessoUsuario salvarAlteracao(AcessoUsuario acessoUsuarioAlterado) throws ObjectNotFoundException {
        AcessoUsuario acessoUsuario = buscaPorID(acessoUsuarioAlterado.getId());
        acessoUsuario.setId(acessoUsuarioAlterado.getId());
        acessoUsuario.setData(acessoUsuarioAlterado.getData());
        acessoUsuario.setUsuario(acessoUsuarioAlterado.getUsuario());
        acessoUsuario.setStand(acessoUsuarioAlterado.getStand());
        return salvar(acessoUsuario);
    }

    public List<Relatorio> quantosUsuariosPorDiaNoStand(Stand stand) {
        return acessoUsuarioRepository.quantosUsuariosPorDiaNoStand(stand);
    }

    public List<Relatorio> quantosUsuariosPorDia() {
        return acessoUsuarioRepository.quantosUsuariosPorDia();
    }
}