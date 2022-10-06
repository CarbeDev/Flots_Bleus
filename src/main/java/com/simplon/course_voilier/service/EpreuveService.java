package com.simplon.course_voilier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.course_voilier.model.Epreuve;
import com.simplon.course_voilier.repository.EpreuveRepo;

@Service
public class EpreuveService {

	@Autowired
	EpreuveRepo er;
	
	public Iterable<Epreuve> getEpreuve(int idCourse) {
		return er.findByCourse_Id(idCourse);
	}
	
	public void addEpreuve(Epreuve epreuve) {
		er.save(epreuve);
	}
}
