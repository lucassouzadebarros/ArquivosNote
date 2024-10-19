package br.com.senacrio.feiravirtual.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Role implements GrantedAuthority {
    @Id
    @Column(name = "role_nome_id")
    private String nomeRole;

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

    public String getNomeRole(){
        return nomeRole;
    }
    public void setNomeRole(String nomeRole){
        this.nomeRole = nomeRole;
    }
    public List<Usuario> getUsuarios(){
        return usuarios;
    }
    public void setUsuarios(List<Usuario> usuarios){
        this.usuarios = usuarios;
    }
    @Override
    public String getAuthority(){
        return this.nomeRole;
    }

}
