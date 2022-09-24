package com.simplon.course_voilier.service;

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
}
