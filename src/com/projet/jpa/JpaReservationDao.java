package com.projet.jpa;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import com.projet.dao.ReservationDao;
import com.projet.dao.AbstractDao;
import com.projet.model.Reservation;

public class JpaReservationDao extends AbstractDao<Reservation, Long> implements ReservationDao {

	protected JpaReservationDao(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Reservation addReservation(Reservation Reservation) {
		return persist(Reservation);

	}

	@Override
	public Reservation findReservationById(Long id) {

		return findById(id);
	}

	@Override
	public List<Reservation> getAllReservation() {

		return findAll();

	}

	@Override
	public void updateReservation(Reservation Reservation) {
		update(Reservation);

	}

	@Override
	public void removeReservation(Reservation Reservation) {
		remove(Reservation);

	}

}
