package com.projet.dao;

import java.util.List;

import com.projet.model.Places;

public interface PlacesDao{
	
	public Places addPlaces(Places Places);
	
	public Places findPlacesById(Long id);
	
	public List<Places> getAllPlaces();
	
	public void updatePlaces(Places Places);
	
	public void removePlaces(Places Places);
}
