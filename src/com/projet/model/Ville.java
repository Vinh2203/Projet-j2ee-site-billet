package com.projet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ville")
@Entity
@Table (name="ville")
public class Ville {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id_ville")
	private Long idVille;
	
	@Column (name="name_ville")
	private String nomVille;
	
	@Column (name="pays")
	private String pays;
	public Ville() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ville(Long idVille, String nomVille, String pays) {
		super();
		this.idVille = idVille;
		this.nomVille = nomVille;
		this.pays = pays;
	}
	public Long getIdVille() {
		return idVille;
	}
	public void setIdVille(Long idVille) {
		this.idVille = idVille;
	}
	public String getNomVille() {
		return nomVille;
	}
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}	
}