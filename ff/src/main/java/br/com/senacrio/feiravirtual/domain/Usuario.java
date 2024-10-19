package br.com.senacrio.feiravirtual.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable, UserDetails {

	private static final long serialVersionUID = 7558668056821787289L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private Integer Id;

	@Column(name = "usuario_nome_completo", length = 250)
	private String nomeCompleto;

	@Column(name = "usuario_cpf", length = 11)
	private String cpf;

	@Column(name = "usuario_email", unique = true, length = 250)
	private String email;

	@Column(name = "usuario_senha", unique = true, length = 200)
	private String senha;

	@Column(name = "usuario_telefone", length = 50)
	private String telefone;

	@Column(name = "usuario_politica_lgpd", length = 11)
	private int statuspoliticaLgpd;
	/*
	@Column(name = "usuario_politica_lgpd_versao", length = 45)
	private String politicaLgpdVersao;
	*/
	@Column(name = "usuario_senac", length = 11)
	private int senac;

	@Column(name = "usuario_status", length = 11)
	private int status;

	@Transient
	private boolean trocaSenha;

	@OneToOne
	@JoinColumn(name = "dado_pessoal_id")
	private CurriculoDadoPessoal dadoPessoal;

	@OneToMany(mappedBy = "usuario")
	@Cascade(CascadeType.ALL)
	private List<SegmentoUsuario> segmentoUsuarios;


	@OneToOne
	@JoinColumn(name = "politica_lgpd_id")
	private PoliticaLgpd politicaLgpd;

	@ManyToMany
	@JoinTable(
			name = "usuario_roles",
			joinColumns = @JoinColumn(
					name = "usuario_cpf", referencedColumnName = "usuario_cpf"),
			inverseJoinColumns = @JoinColumn(
					name = "role_nome_id", referencedColumnName = "role_nome_id"))
	private List<Role> roles;

	public Usuario() {

	}

	public Usuario(Integer Id, String nomeCompleto, String cpf, String email,
				   String senha, String telefone, /*int politicaLgpd, String politicaLgpdVersao,*/
				   int senac, int status, List<SegmentoUsuario> segmentoUsuarios, /*List<Curriculo> curriculos,*/
				   List<Candidatura> candidaturas, List<EventoUsuario> eventoUsuarios, List<Role> roles) {
		super();
		this.Id = Id;
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		//this.politicaLgpd = politicaLgpd;
		//this.politicaLgpdVersao = politicaLgpdVersao;

		this.senac = senac;
		this.status = status;
		this.segmentoUsuarios = segmentoUsuarios;
		//this.curriculos = curriculos;
		//this.candidaturas = candidaturas;
		//this.eventoUsuarios = eventoUsuarios;
		this.roles = roles;
	}

	//Inicio Override dos métodos do Spring security
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return (Collection<? extends GrantedAuthority>) this.roles;
	}
	@Override
	public String getPassword(){
		return this.senha;
	}
	@Override
	public String getUsername(){
		return this.cpf;
	}
	@Override
	public boolean isAccountNonExpired(){
		return true;
	}
	@Override
	public boolean isAccountNonLocked(){
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired(){
		return true;
	}
	@Override
	public boolean isEnabled(){
		return true;
	}
	//Fim Override dos métodos do Spring security

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getSenac() {
		return senac;
	}

	public void setSenac(int senac) {
		this.senac = senac;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<SegmentoUsuario> getSegmentoUsuarios() {
		return segmentoUsuarios;
	}

	public void setSegmentoUsuarios(List<SegmentoUsuario> segmentoUsuarios) {
		this.segmentoUsuarios = segmentoUsuarios;
	}

	public int getStatuspoliticaLgpd() {
		return statuspoliticaLgpd;
	}

	public void setStatuspoliticaLgpd(int statuspoliticaLgpd) {
		this.statuspoliticaLgpd = statuspoliticaLgpd;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public CurriculoDadoPessoal getDadoPessoal() {
		return dadoPessoal;
	}

	public void setDadoPessoal(CurriculoDadoPessoal dadoPessoal) {
		this.dadoPessoal = dadoPessoal;
	}

	public PoliticaLgpd getPoliticaLgpd() {
		return politicaLgpd;
	}
	public void setPoliticaLgpd(PoliticaLgpd politicaLgpd) {
		this.politicaLgpd = politicaLgpd;
	}

	public boolean isTrocaSenha() {
		return trocaSenha;
	}

	public void setTrocaSenha(boolean trocaSenha) {
		this.trocaSenha = trocaSenha;
	}
}