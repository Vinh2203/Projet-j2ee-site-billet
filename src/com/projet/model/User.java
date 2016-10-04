package com.projet.model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="user")
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "url_img")
	private String url;

	@Column(name = "role")
	private int role;

	public User(Long id, String name, String email, String password, String url, int role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.url = url;
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public static User checkFacebook(String email) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT p FROM User as p WHERE p.email = :email AND role = 1");
		q.setParameter("email", email);
		@SuppressWarnings("unchecked")
		List<User> u = q.getResultList();
		em.close();
		emf.close();
		if(u.isEmpty()) return null;
		else return u.get(0);
	}
	
	public static User checkGoogle(String email) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT p FROM User as p WHERE p.email = :email AND role = 0");
		q.setParameter("email", email);
		@SuppressWarnings("unchecked")
		List<User> u = q.getResultList();
		em.close();
		emf.close();
		if(u.isEmpty()) return null;
		else return u.get(0);
	}
	
	public static User check(String email,String passowrd) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT p FROM User as p WHERE p.email = :email AND p.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", getMD5(passowrd));
		@SuppressWarnings("unchecked")
		List<User> u = q.getResultList();
		em.close();
		emf.close();
		if(u.isEmpty()) return null;
		else return u.get(0);
	}
	
	public static boolean existEmail(String email) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT p FROM User as p WHERE p.email = :email ");
		q.setParameter("email", email);
		@SuppressWarnings("unchecked")
		List<User> u = q.getResultList();
		em.close();
		emf.close();
		if(u.isEmpty()) return false;
		else return true;
	}
	
	public static String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);
			// Now we need to zero pad it if you actually want the full 32
			// chars.
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}