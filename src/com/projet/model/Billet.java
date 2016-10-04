package com.projet.model;

import java.text.SimpleDateFormat;
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

@XmlRootElement(name = "billet")
@Entity
@Table(name = "billet")
public class Billet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_billet")
	private Long id;

	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_reservation")
	private Reservation reservation;

	@Column(name = "nom_client")
	private String nom_client;

	@Column(name = "type_class")
	private int type_class;

	@Column(name = "prix")
	private double prix;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_dept")
	private Date dateDept;

	@Temporal(TemporalType.TIME)
	@Column(name = "heure_dept")
	private Date heureDept;

	@Temporal(TemporalType.TIME)
	@Column(name = "heure_arrive")
	private Date heureArrive;

	@Column(name = "ville_dept")
	private String ville_dept;

	@Column(name = "ville_arrive")
	private String ville_arrive;

	@Column(name = "numero_billet")
	private String numero_billet;

	public Billet(Long id, Reservation reservation, String nom_client, int type_class, double prix, Date dateDept,
			Date heureDept, Date heureArrive, String ville_dept, String ville_arrive, String numero_billet) {
		super();
		this.id = id;
		this.reservation = reservation;
		this.nom_client = nom_client;
		this.type_class = type_class;
		this.prix = prix;
		this.dateDept = dateDept;
		this.heureDept = heureDept;
		this.heureArrive = heureArrive;
		this.ville_dept = ville_dept;
		this.ville_arrive = ville_arrive;
		this.numero_billet = numero_billet;
	}

	public Billet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public String getNom_client() {
		return nom_client;
	}

	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
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

	public Date getHeureDept() {
		return heureDept;
	}

	public void setHeureDept(Date heureDept) {
		this.heureDept = heureDept;
	}

	public Date getHeureArrive() {
		return heureArrive;
	}

	public void setHeureArrive(Date heureArrive) {
		this.heureArrive = heureArrive;
	}

	public String getVille_dept() {
		return ville_dept;
	}

	public void setVille_dept(String ville_dept) {
		this.ville_dept = ville_dept;
	}

	public String getVille_arrive() {
		return ville_arrive;
	}

	public void setVille_arrive(String ville_arrive) {
		this.ville_arrive = ville_arrive;
	}

	public String getNumero_billet() {
		return numero_billet;
	}

	public void setNumero_billet(String numero_billet) {
		this.numero_billet = numero_billet;
	}

	public static List<Billet> searchBilletByIdReservation(long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("SELECT b FROM Billet AS b WHERE id_reservation = " + id);
		@SuppressWarnings("unchecked")
		List<Billet> list = (List<Billet>) q.getResultList();
		em.close();
		emf.close();
		return list;
	}

	@SuppressWarnings("deprecation")
	public boolean timeIsPass() {
		boolean test;
		Date now = new Date();
		String[] tab = this.getDateDept().toString().split("-");
		Date date = new Date(Integer.parseInt(tab[0].trim()) - 1900, Integer.parseInt(tab[1].trim()) - 1,
				Integer.parseInt(tab[2].trim()));
		tab = this.getHeureDept().toString().split(":");
		date.setHours(Integer.parseInt(tab[0].trim()));
		date.setMinutes(Integer.parseInt(tab[1].trim()));
		System.out.println(date);
		System.out.println(now);
		if (date.before(now)) {
			test = true;
			System.out.println("1");
		} else {
			test = false;
			System.out.println("4");
		}

		return test;
	}

	public int convertTimeToSecond(String time) {
		String[] units = time.split(":"); // will break the string up into an
											// array
		int heure = Integer.parseInt(units[0]); // first element
		int minutes = Integer.parseInt(units[1]); // second element
		int duration = 3600 * heure + 60 * minutes; // add up our values

		return duration;
	}

	public static String convertDate(Date date) {
		return new SimpleDateFormat("dd/MM/YYYY").format(date);
	}

	public String convertTime(Date time) {
		return new SimpleDateFormat("HH:mm").format(time);
	}
}