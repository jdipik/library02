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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "libri")
@Proxy(lazy = false)
public class Libro extends GenericEntity {
	
	private static final long serialVersionUID = -7212363568112100026L;

	@NotNull
	private String titolo;
	
	@NotNull
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "autori_libri", joinColumns = { @JoinColumn( name = "libro_id")},
								inverseJoinColumns = { @JoinColumn(name = "autore_id")}
				)
	@JsonManagedReference
//	@JsonIgnore
	private Set<Autore> autore;
	
	@NotNull
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "clienti_libri", joinColumns = { @JoinColumn( name = "libro_id")},
									inverseJoinColumns = { @JoinColumn(name = "clienti_id")}
			)
	@JsonManagedReference
//	@JsonIgnore
	private Set<Cliente> cliente;
	
	@Pattern(regexp = "[0-9]*")
	private Integer prezzo;
	
	public Libro() {
		autore = new HashSet<>();
		cliente = new HashSet<>();
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Set<Autore> getAutore() {
		return autore;
	}

	public void setAutore(Set<Autore> autore) {
		this.autore = autore;
	}

	public Set<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(Set<Cliente> cliente) {
		this.cliente = cliente;
	}

	public Integer getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}



}
