package com.projet.dao;

import java.util.List;

import com.projet.model.Trajet;

public interface TrajetDao{
	
	public Trajet addTrajet(Trajet Trajet);
	
	public Trajet findTrajetById(Long id);
	
	public List<Trajet> getAllTrajet();
	
	public void updateTrajet(Trajet Trajet);
	
	public void removeTrajet(Trajet Trajet);
}
