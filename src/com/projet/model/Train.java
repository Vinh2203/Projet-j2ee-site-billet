package com.projet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="train")
@Entity
@Table(name = "train")
public class Train {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_train")
	private Long id;
	
	@Column(name = "numero_train")
	private String numero_train;
	
	public Train(Long id, String numero_train) {
		super();
		this.id = id;
		this.numero_train = numero_train;
	}

	public Train() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero_train() {
		return numero_train;
	}

	public void setNumero_train(String numero_train) {
		this.numero_train = numero_train;
	}
}