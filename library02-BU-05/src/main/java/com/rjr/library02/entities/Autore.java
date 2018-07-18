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
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "autori")
@Proxy(lazy = false)
public class Autore extends GenericEntity{

	private static final long serialVersionUID = -756796619088821212L;
	
	@NotNull
	@Pattern(regexp = "^[\\p{L} .'-]+$")
	private String nome;
	
	@NotNull
	@Pattern(regexp = "^[\\p{L} .'-]+$")
	private String cognome;
	
	@Digits(integer=4, fraction = 0)
	@Size(min = 4, max = 4)
	private Integer annoNascita;
	
	@Email
	private String email;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "autori_libri", joinColumns = { @JoinColumn( name = "autore_id")},
									inverseJoinColumns = { @JoinColumn(name = "libro_id")}
			)
	@JsonBackReference
	private Set<Libro> libro;
	
	public Autore() {
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

	public Integer getAnnoNascita() {
		return annoNascita;
	}

	public void setAnnoNascita(Integer annoNascita) {
		this.annoNascita = annoNascita;
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
