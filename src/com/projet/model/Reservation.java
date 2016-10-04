package com.projet.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="reservation")
@Entity
@Table(name = "reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reservation")
	private Long id;
	
	@Column(name = "id_user")
	private Long id_user;
	
	@Column(name = "nombre_client")
	private int nombre_client;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_reservation")
	private Date date_reservation;

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(Long id, Long id_user, int nombre_client, Date date_reservation) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.nombre_client = nombre_client;
		this.date_reservation = date_reservation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public int getNombre_client() {
		return nombre_client;
	}

	public void setNombre_client(int nombre_client) {
		this.nombre_client = nombre_client;
	}

	public Date getDate_reservation() {
		return date_reservation;
	}

	public void setDate_reservation(Date string) {
		this.date_reservation = string;
	}
	
	public static List<Reservation> searchReservationByUser(long id){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    	EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("SELECT r FROM Reservation AS r WHERE id_user = "+id);
		@SuppressWarnings("unchecked")
		List<Reservation> list = (List<Reservation>) q.getResultList();
		em.close();		
		return list;
	}	
	
}