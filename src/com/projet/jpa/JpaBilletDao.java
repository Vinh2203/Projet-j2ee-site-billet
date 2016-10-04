package com.projet.jpa;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import com.projet.dao.BilletDao;
import com.projet.dao.AbstractDao;
import com.projet.model.Billet;

public class JpaBilletDao extends AbstractDao<Billet, Long> implements BilletDao {

	protected JpaBilletDao(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Billet addBillet(Billet Billet) {
		return persist(Billet);

	}

	@Override
	public Billet findBilletById(Long id) {

		return findById(id);
	}

	@Override
	public List<Billet> getAllBillet() {

		return findAll();

	}

	@Override
	public void updateBillet(Billet Billet) {
		update(Billet);

	}

	@Override
	public void removeBillet(Billet Billet) {
		remove(Billet);

	}

}
