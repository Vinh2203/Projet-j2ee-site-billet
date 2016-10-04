package com.projet.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="places")
@Entity
@Table(name = "places")
public class Places {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_places")
	private Long id;

	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_trajet")
	private Trajet trajet;

	@Column(name = "nombre_places")
	private int nombrePlaces;

	@Column(name = "type_class")
	private int type_class;

	@Column(name = "prix")
	private double prix;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_dept")
	private Date dateDept;

	public Places(Long id, Trajet trajet, int nombrePlaces, int type_class, double prix, Date dateDept) {
		super();
		this.id = id;
		this.trajet = trajet;
		this.nombrePlaces = nombrePlaces;
		this.type_class = type_class;
		this.prix = prix;
		this.dateDept = dateDept;
	}

	public Places() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	public int getNombrePlaces() {
		return nombrePlaces;
	}

	public void setNombrePlaces(int nombrePlaces) {
		this.nombrePlaces = nombrePlaces;
	}

	public int getType_class() {
		return type_class;
	}

	public void setType_class(int type_class) {
		this.type_class = type_class;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Date getDateDept() {
		return dateDept;
	}

	public void setDateDept(Date dateDept) {
		this.dateDept = dateDept;
	}

	public static HashMap<Long, Places> searchPlaces(List<Trajet> list, String dateDept, String type) {
		HashMap<Long, Places> mapPlaces = new HashMap<Long, Places>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();
		String list_id_trajet = "(";
		String virg = "";
		for (Trajet t : list) {
			list_id_trajet += virg;
			list_id_trajet += t.getId();
			virg = ",";
		}
		
		if(list.size()==0){
			list_id_trajet = "('')";
		}

		list_id_trajet += ")";
		Query q = em.createQuery("SELECT p FROM Places AS p WHERE id_trajet IN " + list_id_trajet + " AND date_dept = '"
				+ dateDept + "' AND type_class =" + type);

		@SuppressWarnings("unchecked")
		List<Places> list_places = (List<Places>) q.getResultList();
		em.close();
		emf.close();
		int cpt = 0;
		for (Places p : list_places) {
			mapPlaces.put(list.get(cpt).getId(), p);
			cpt++;
		}
		return mapPlaces;
	}
}
