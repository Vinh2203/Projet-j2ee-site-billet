package com.projet.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.projet.dao.BilletDao;
import com.projet.dao.DaoFactory;
import com.projet.dao.PlacesDao;
import com.projet.dao.ReservationDao;
import com.projet.dao.TrainDao;
import com.projet.dao.TrajetDao;
import com.projet.dao.UserDao;
import com.projet.dao.VilleDao;

public class JpaDaoFactory extends DaoFactory {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
	private JpaUserDao user;
	private JpaVilleDao ville;
	private JpaBilletDao billet;
	private JpaPlacesDao places;
	private JpaTrainDao train;
	private JpaTrajetDao trajet;
	private JpaReservationDao reservation;

	@Override
	public UserDao getUserDao() {
		if (user == null) {
			user = new JpaUserDao(emf);
		}
		return user;
	}
	
	@Override
	public VilleDao getVilleDao() {
		if (ville == null) {
			ville = new JpaVilleDao(emf);
		}
		return ville;
	}

	@Override
	public PlacesDao getPlacesDao() {
		if (places == null) {
			places = new JpaPlacesDao(emf);
		}
		return places;
	}

	@Override
	public ReservationDao getReservationDao() {
		if (reservation == null) {
			reservation = new JpaReservationDao(emf);
		}
		return reservation;
	}

	@Override
	public TrainDao getTrainDao() {
		if (train == null) {
			train = new JpaTrainDao(emf);
		}
		return train;
	}

	@Override
	public BilletDao getBilletDao() {
		if (billet == null) {
			billet = new JpaBilletDao(emf);
		}
		return billet;
	}

	@Override
	public TrajetDao getTrajetDao() {
		if (trajet == null) {
			trajet = new JpaTrajetDao(emf);
		}
		return trajet;
	}
}
