package com.simplon.course_voilier.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.simplon.course_voilier.model.Entreprise;
import com.simplon.course_voilier.repository.EntrepriseRepo;

@Service
public class EntrepriseService {

    
    
    
	@Autowired
	private EntrepriseRepo er;
	
	
	public Iterable<Entreprise> getAllSponsor() {
		return er.findAll();
	}
	
	public void addSponsor(Entreprise e) {
		er.save(e);
	}

	
	
	public void updateEntreprise(int id,String nom) {
	    Entreprise modif = er.findById(id).get();
	    modif.setNom(nom);
	    er.save(modif);
}
	   
	
	    
	
}
