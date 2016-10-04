package com.projet.jpa;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import com.projet.dao.VilleDao;
import com.projet.dao.AbstractDao;
import com.projet.model.Ville;

public class JpaVilleDao extends AbstractDao<Ville, Long> implements VilleDao {

	protected JpaVilleDao(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Ville addVille(Ville Ville) {
		return persist(Ville);

	}

	@Override
	public Ville findVilleById(Long id) {

		return findById(id);
	}

	@Override
	public List<Ville> getAllVille() {

		return findAll();

	}

	@Override
	public void updateVille(Ville Ville) {
		update(Ville);

	}

	@Override
	public void removeVille(Ville Ville) {
		remove(Ville);

	}

}
