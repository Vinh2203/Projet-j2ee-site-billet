package com.projet.dao;

import java.util.List;

import com.projet.model.Train;

public interface TrainDao{
	
	public Train addTrain(Train Train);
	
	public Train findTrainById(Long id);
	
	public List<Train> getAllTrain();
	
	public void updateTrain(Train Train);
	
	public void removeTrain(Train Train);
}
