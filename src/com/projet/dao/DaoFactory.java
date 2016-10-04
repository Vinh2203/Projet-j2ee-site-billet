package com.projet.dao;

import com.projet.jpa.JpaDaoFactory;

public abstract class DaoFactory {
	
	public static DaoFactory getDaoFactory() {
		return new JpaDaoFactory();
	}
	
	public abstract UserDao getUserDao();
	public abstract PlacesDao getPlacesDao();
	public abstract ReservationDao getReservationDao();
	public abstract VilleDao getVilleDao();
	public abstract TrainDao getTrainDao();
	public abstract BilletDao getBilletDao();
	public abstract TrajetDao getTrajetDao();
	
	
}
