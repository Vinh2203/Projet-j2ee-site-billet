package com.projet.dao;

import java.util.List;

import com.projet.model.Ville;

public interface VilleDao {

	Ville addVille(Ville Ville);
	
	public Ville findVilleById(Long id);
	
	public List<Ville> getAllVille();
	
	public void updateVille(Ville Ville);
	
	public void removeVille(Ville Ville);
}

