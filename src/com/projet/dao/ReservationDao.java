package com.projet.dao;

import java.util.List;

import com.projet.model.Reservation;

public interface ReservationDao{
	
	public Reservation addReservation(Reservation Reservation);
	
	public Reservation findReservationById(Long id);
	
	public List<Reservation> getAllReservation();
	
	public void updateReservation(Reservation Reservation);
	
	public void removeReservation(Reservation Reservation);
}
