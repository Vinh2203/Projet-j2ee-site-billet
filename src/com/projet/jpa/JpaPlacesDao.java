package com.projet.jpa;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import com.projet.dao.PlacesDao;
import com.projet.dao.AbstractDao;
import com.projet.model.Places;

public class JpaPlacesDao extends AbstractDao<Places, Long> implements PlacesDao {

	protected JpaPlacesDao(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Places addPlaces(Places Places) {
		return persist(Places);

	}

	@Override
	public Places findPlacesById(Long id) {

		return findById(id);
	}

	@Override
	public List<Places> getAllPlaces() {

		return findAll();

	}

	@Override
	public void updatePlaces(Places Places) {
		update(Places);

	}

	@Override
	public void removePlaces(Places Places) {
		remove(Places);

	}

}
