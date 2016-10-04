package com.projet.jpa;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import com.projet.dao.TrainDao;
import com.projet.dao.AbstractDao;
import com.projet.model.Train;

public class JpaTrainDao extends AbstractDao<Train, Long> implements TrainDao {

	protected JpaTrainDao(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Train addTrain(Train Train) {
		return persist(Train);

	}

	@Override
	public Train findTrainById(Long id) {

		return findById(id);
	}

	@Override
	public List<Train> getAllTrain() {

		return findAll();

	}

	@Override
	public void updateTrain(Train Train) {
		update(Train);

	}

	@Override
	public void removeTrain(Train Train) {
		remove(Train);

	}

}
