package com.rjr.library02.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "clienti")
@Proxy(lazy = false)
public class Cliente extends GenericEntity {
	
	public static final long serialVersionUID = -8080552563125969834L;

	@NotNull
	@Pattern(regexp = "^[\\p{L} .'-]+$")
	private String nome;
	
	@NotNull
	@Pattern(regexp = "^[\\p{L} .'-]+$")
	private String cognome;
	
	@Pattern(regexp = "^[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]$")
	private String codiceFiscale;
	
	@Email
	private String email;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "clienti_libri", joinColumns = { @JoinColumn( name = "clienti_id")},
									inverseJoinColumns = { @JoinColumn(name = "libro_id")}
			)
	@JsonBackReference
//	@JsonIgnore
	private Set<Libro> libro;
	
	public Cliente() {
		libro = new HashSet<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Libro> getLibro() {
		return libro;
	}

	public void setLibro(Set<Libro> libro) {
		this.libro = libro;
	}



}
