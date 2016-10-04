package com.projet.dao;

import java.util.List;

import com.projet.model.Billet;

public interface BilletDao{
	
	public Billet addBillet(Billet billet);
	
	public Billet findBilletById(Long id);
	
	public List<Billet> getAllBillet();
	
	public void updateBillet(Billet billet);
	
	public void removeBillet(Billet billet);
}
