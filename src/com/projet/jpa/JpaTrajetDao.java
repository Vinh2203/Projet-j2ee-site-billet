package com.projet.jpa;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import com.projet.dao.TrajetDao;
import com.projet.dao.AbstractDao;
import com.projet.model.Trajet;

public class JpaTrajetDao extends AbstractDao<Trajet, Long> implements TrajetDao {

	protected JpaTrajetDao(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Trajet addTrajet(Trajet Trajet) {
		return persist(Trajet);

	}

	@Override
	public Trajet findTrajetById(Long id) {

		return findById(id);
	}

	@Override
	public List<Trajet> getAllTrajet() {

		return findAll();

	}

	@Override
	public void updateTrajet(Trajet Trajet) {
		update(Trajet);

	}

	@Override
	public void removeTrajet(Trajet Trajet) {
		remove(Trajet);

	}

}
