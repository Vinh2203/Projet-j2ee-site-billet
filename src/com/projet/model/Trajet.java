package com.projet.model;

import java.util.Date;
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


@XmlRootElement(name="trajet")
@Entity
@Table(name = "trajet")
public class Trajet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_trajet")
	private Long id;
	
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_ville_dept", referencedColumnName = "id_ville")
	private Ville ville_dept;
	 
	
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_ville_arrive", referencedColumnName = "id_ville")
	private Ville ville_arrive;
	
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_train")
	private Train train;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "heure_dept")
	private Date heureDept;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "heure_arrive")
	private Date heureArrive;
	
	private int typeDate;
	public Trajet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trajet(Long id, Ville ville_dept, Ville ville_arrive, Train train, Date heureDept, Date heureArrive,
			int typeDate) {
		super();
		this.id = id;
		this.ville_dept = ville_dept;
		this.ville_arrive = ville_arrive;
		this.train = train;
		this.heureDept = heureDept;
		this.heureArrive = heureArrive;
		this.typeDate = typeDate;
	}

	public int getTypeDate() {
		return typeDate;
	}

	public void setTypeDate(int typeDate) {
		this.typeDate = typeDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ville getVille_dept() {
		return ville_dept;
	}

	public void setVille_dept(Ville ville_dept) {
		this.ville_dept = ville_dept;
	}

	public Ville getVille_arrive() {
		return ville_arrive;
	}

	public void setVille_arrive(Ville ville_arrive) {
		this.ville_arrive = ville_arrive;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public Date getHeureDept() {
		return heureDept;
	}

	public void setHeureDept(Date heureDept) {
		this.heureDept = heureDept;
	}

	public Date getHeureArrive() {
		return heureArrive;
	}

	public static List<Trajet> searchTrajetSimple(long idVille_dept,long idVille_des,String heureDept,
			int typeDate){
		heureDept = "0"+heureDept+":00:00";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    	EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("SELECT p FROM Trajet AS p WHERE id_ville_dept = "+idVille_dept+
								" AND id_ville_arrive ="+idVille_des
								+" AND typeDate = "+ typeDate+" AND heure_dept >= '"+heureDept+"'");
		@SuppressWarnings("unchecked")
		List<Trajet> list = (List<Trajet>) q.getResultList();
		em.close();
		emf.close();
		
		return list;
	}	
	
	public static Trajet searchTrajetByTrain(Train t){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    	EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("SELECT t FROM Trajet AS t WHERE id_train = "+t.getId());
		
		Trajet trajet = (Trajet) q.getSingleResult();
		em.close();
		emf.close();
		
		return trajet;
	}	
	
	public void setHeureArrive(Date heureArrive) {
		this.heureArrive = heureArrive;
	}
}